const express = require("express");
const cors = require("cors");

const db = require("./db");
const usersRouter = require("./routes/users");
const channelsRouter = require("./routes/channels");

db.client
  .connect()
  .then(() => console.info("Connected to PostgreSQL"))
  .catch((err) =>
    console.error("Error connecting to PostgreSQL:", err.message)
  );

const app = express();

// middlewares
app.use(express.json());
app.use(cors());

// api routes
app.use("/api/users", usersRouter);
app.use("/api/channels", channelsRouter);

if (process.env.NODE_ENV === "production") {
  const path = require("path");
  const buildPath = path.resolve(__dirname, "..", "client", "build");
  app.use(express.static(buildPath));
  app.get("*", (request, response) => {
    response.sendFile(path.join(buildPath, "index.html"));
  });
}

module.exports = app;
