import axios from "axios";

const api = axios.create({
  baseURL: "/api/users",
});

export const login = async (userInfo) => {
  return await api.post("/login", userInfo);
};

export const signup = async (userInfo) => {
  return await api.post("/", userInfo);
};
