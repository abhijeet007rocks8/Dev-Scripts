import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";

import * as channelAPI from "../api/channel";

export const loadChannels = createAsyncThunk(
  "channels/loadChannels",
  async (_, { rejectWithValue }) => {
    try {
      const response = await channelAPI.getChannels();
      return response.data;
    } catch (err) {
      return rejectWithValue(err.response);
    }
  }
);

const initialState = {
  byId: {},
  allIds: [],
  loading: true,
  active: null,
};

const channelsSlice = createSlice({
  name: "channels",
  initialState,
  reducers: {
    setActiveChannel(state, action) {
      state.active = action.payload;
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(loadChannels.pending, (state, action) => {
        state.loading = true;
      })
      .addCase(loadChannels.fulfilled, (state, action) => {
        state.byId = {};
        state.allIds = [];
        state.loading = false;
        action.payload.forEach((channel) => {
          state.byId[channel.id] = channel;
          state.allIds.push(channel.id);
        });
      });
  },
});

export const { setActiveChannel } = channelsSlice.actions;

export default channelsSlice.reducer;
