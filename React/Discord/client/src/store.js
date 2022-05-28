import { configureStore } from "@reduxjs/toolkit";

import socketMiddleware from "./middleware/socketMiddleware";
import chatReducer from "./reducers/chatReducer";
import channelsReducer from "./reducers/channelsReducer";
import sessionReducer from "./reducers/sessionReducer";
import sidebarReducer from "./reducers/sidebarReducer";
import memberListReducer from "./reducers/memberListReducer";

const store = configureStore({
  reducer: {
    chat: chatReducer,
    channels: channelsReducer,
    session: sessionReducer,
    sidebar: sidebarReducer,
    memberList: memberListReducer,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({ serializableCheck: false }).concat(socketMiddleware),
});

export default store;
