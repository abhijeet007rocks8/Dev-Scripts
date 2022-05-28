require("dotenv").config();
const http = require("http");
const { Server } = require("socket.io");
const app = require("./app");
const db = require("./db");

const server = http.createServer(app);
const io = new Server(server);
const clients = {};

io.on("connection", (socket) => {
  socket.on("new-client", (user) => {
    clients[socket.id] = { ...user, activeChannelId: null };
    io.emit("update-member-list", Object.values(clients));
  });

  socket.on("set-active-channel", (activeChannelId) => {
    if (clients[socket.id].activeChannelId) {
      socket.leave(`Channel: ${clients[socket.id].activeChannelId}`);
    }
    clients[socket.id].activeChannelId = activeChannelId;
    socket.join(`Channel: ${activeChannelId}`);
  });

  socket.on("send-message", async (message) => {
    const { user, channelId, content } = message;
    const result = await db.query(
      "INSERT INTO messages (author_id, channel_id, content) " +
        "VALUES ($1, $2, $3) RETURNING * ",
      [user.id, channelId, content]
    );
    io.to(`Channel: ${channelId}`).emit("send-message", {
      id: result.rows[0].id,
      createdAt: result.rows[0].created_at,
      content,
      channelId,
      user,
    });
  });

  socket.on("edit-message", async (message) => {
    const { user, channelId, id, content } = message;
    const result = await db.query(
      "UPDATE messages SET content = $1, updated_at = NOW() " +
        "WHERE id = $2 RETURNING *",
      [content, id]
    );

    io.to(`Channel: ${channelId}`).emit("edit-message", {
      id,
      content,
      user,
      channelId,
      createdAt: result.rows[0].created_at,
      updatedAt: result.rows[0].updated_at,
    });
  });

  socket.on("delete-message", async (message) => {
    const { channelId, id } = message;
    await db.query("DELETE FROM messages WHERE id = $1", [id]);
    io.to(`Channel: ${channelId}`).emit("delete-message", { id });
  });

  socket.on("typing", () => {
    socket.broadcast
      .to(`Channel: ${clients[socket.id].activeChannelId}`)
      .emit("typing", clients[socket.id]);
  });

  socket.on("stop-typing", () => {
    socket.broadcast
      .to(`Channel: ${clients[socket.id].activeChannelId}`)
      .emit("stop-typing", clients[socket.id]);
  });

  socket.on("disconnect", () => {
    delete clients[socket.id];
    io.emit("update-member-list", Object.values(clients));
  });
});

const PORT = process.env.PORT || 3001;

server.listen(PORT, () => {
  console.info(`Server running on port ${PORT}`);
});
