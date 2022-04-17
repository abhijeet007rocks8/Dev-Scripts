import axios from "axios";

const authentication = async () => {
  try {
    const { data } = await axios.get("/accounts/authentication", {
      withCredentials: true,
    });
    return {
      isAuth: data.isAuthenticate,
      user: data.user,
    };
  } catch (error) {
    throw error;
  }
};

export default authentication;
