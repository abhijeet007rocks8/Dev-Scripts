import io from "socket.io-client";

import {
  receiveNewMessage,
  receiveEditedMessage,
  receiveDeletedMessage,
  updateTypingUser,
} from "../reducers/chatReducer";
import { updateOnlineUsers } from "../reducers/memberListReducer";

const socketMiddleware = () => {
  return (storeAPI) => {
    // This part is called when the Redux store is created
    const socket = io("/", { autoConnect: false });

    socket.on("send-message", (message) => {
      storeAPI.dispatch(receiveNewMessage(message));
    });

    socket.on("edit-message", (message) => {
      storeAPI.dispatch(receiveEditedMessage(message));
    });

    socket.on("delete-message", (message) => {
      storeAPI.dispatch(receiveDeletedMessage(message));
    });

    socket.on("update-member-list", (user) => {
      storeAPI.dispatch(updateOnlineUsers(user));
    });

    socket.on("typing", (user) => {
      storeAPI.dispatch(updateTypingUser(user));
    });

    socket.on("stop-typing", (user) => {
      storeAPI.dispatch(updateTypingUser(null));
    });

    // This part is called when an action is dispatched
    return (next) => (action) => {
      switch (action.type) {
        case "channels/setActiveChannel":
          socket.emit("set-active-channel", JSON.stringify(action.payload));
          break;
        case "chat/sendMessage":
          socket.emit("send-message", action.payload);
          break;
        case "chat/editMessage":
          socket.emit("edit-message", action.payload);
          break;
        case "chat/deleteMessage":
          socket.emit("delete-message", action.payload);
          break;
        case "chat/typing":
          socket.emit("typing", action.payload);
          break;
        case "chat/stopTyping":
          socket.emit("stop-typing", action.payload);
          break;
        case "session/connectSocket":
          socket.connect();
          socket.emit("new-client", action.payload);
          break;
        case "session/logout":
          socket.close();
          break;
        default:
          break;
      }
      return next(action);
    };
  };
};

export default socketMiddleware();
