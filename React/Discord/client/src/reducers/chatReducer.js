import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";

import * as channelAPI from "../api/channel";

export const loadMessages = createAsyncThunk(
  "chat/loadMessages",
  async (channelId, { rejectWithValue }) => {
    try {
      const response = await channelAPI.getMessages(channelId);
      return response.data;
    } catch (err) {
      return rejectWithValue(err.response);
    }
  }
);

const initialState = {
  messages: { byId: {}, allIds: [], loading: true },
  typingUser: null,
};

const chatSlice = createSlice({
  name: "chat",
  initialState,
  reducers: {
    receiveNewMessage(state, action) {
      const message = action.payload;
      state.messages.byId[message.id] = message;
      state.messages.allIds.push(message.id);
    },
    receiveEditedMessage(state, action) {
      const message = action.payload;
      state.messages.byId[message.id] = message;
    },
    receiveDeletedMessage(state, action) {
      const message = action.payload;
      delete state.messages.byId[message.id];
      state.messages.allIds = state.messages.allIds.filter(
        (id) => id !== message.id
      );
    },
    sendMessage(state, action) {},
    editMessage(state, action) {},
    deleteMessage(state, action) {},
    typing(state, action) {},
    stopTyping(state, action) {},
    updateTypingUser(state, action) {
      state.typingUser = action.payload;
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(loadMessages.pending, (state, action) => {
        state.messages.loading = true;
      })
      .addCase(loadMessages.fulfilled, (state, action) => {
        state.messages.byId = {};
        state.messages.allIds = [];
        state.messages.loading = false;
        action.payload.forEach((message) => {
          state.messages.byId[message.id] = message;
          state.messages.allIds.push(message.id);
        });
      });
  },
});

export const {
  setActiveChannel,
  receiveNewMessage,
  receiveEditedMessage,
  receiveDeletedMessage,
  updateOnlineUsers,
  updateTypingUser,
  editMessage,
  sendMessage,
  deleteMessage,
  stopTyping,
  typing,
} = chatSlice.actions;

export default chatSlice.reducer;
