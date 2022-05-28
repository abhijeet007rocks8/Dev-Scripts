import axios from "axios";

const api = axios.create({
  baseURL: "/api/channels",
});

export const getChannels = async () => {
  return await api.get("/");
};

export const getMessages = async (channelId) => {
  return await api.get(`/${channelId}`);
};
