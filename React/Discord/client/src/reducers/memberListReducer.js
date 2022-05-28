import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  onlineUsers: [],
  isOpen: false,
};

const memberListSlice = createSlice({
  name: "memberList",
  initialState,
  reducers: {
    updateOnlineUsers(state, action) {
      state.onlineUsers = action.payload;
    },
    toggleMemberList(state, action) {
      state.isOpen = !state.isOpen;
    },
  },
});

export const { updateOnlineUsers, toggleMemberList } = memberListSlice.actions;

export default memberListSlice.reducer;
