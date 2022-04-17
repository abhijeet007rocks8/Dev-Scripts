const User = require("../models/userSchema");
const jwt = require("jsonwebtoken");
const bcrypt = require("bcryptjs");

const signup = async (req, res) => {
  const user = new User(req.body);
  try {
    const token = await user.generateAuthToken();
    await user.save();
    res.cookie("auth_token", token, {
      maxAge: 2629800000,
      httpOnly: true,
    });
    res.status(201).json({ code: 201, isComplete: true });
  } catch (error) {
    console.log(error);
    res
      .status(400)
      .json({ code: 400, message: "invalid data or invalid syntax" });
  }
};

const isExistPhone = async (req, res) => {
  const phoneNumber = req.body.phone;
  try {
    const result = await User.findOne({ phone: phoneNumber });
    if (result) {
      res.json({ code: 200, isExist: true });
    } else {
      res.send({ code: 200, isExist: false });
    }
  } catch (error) {
    console.log(error);
    res.status(400).json({ code: 400, message: "Couldn't understand request" });
  }
};

const authentication = async (req, res) => {
  try {
    const token = req.cookies.auth_token;
    if (token) {
      const verifyToken = jwt.verify(token, process.env.SECRET_KEY);
      const userInfo = await User.findOne(
        { _id: verifyToken._id, "tokens.token": token },
        { password: 0, tokens: 0 }
      );

      //get Result
      const user = userInfo._doc;

      res.status(200).json({
        code: 200,
        isAuthenticate: true,
        user: {
          ...user,
          _id: user._id.toString(),
        },
      });
    } else {
      res.status(401).json({
        code: 401,
        isAuthenticate: false,
        message: "invalid provided token. Test",
      });
    }
  } catch (error) {
    console.log(error);
    res.status(401).json({
      code: 401,
      isAuthenticate: false,
      message: "invalid provided token.",
    });
  }
};

const login = async (req, res) => {
  try {
    const { phone, password } = req.body;
    const userLogin = await User.findOne({ phone: phone });
    if (!userLogin) {
      return res
        .status(401)
        .json({ isLogin: false, message: "login/invalid-phone-or-password" });
    }
    let isMatch = await bcrypt.compare(password, userLogin.password);
    if (isMatch) {
      const token = await userLogin.generateAuthToken();
      res.cookie("auth_token", token, {
        maxAge: 2629800000,
        httpOnly: true,
      });
      res.json({ isLogin: true, message: "User Login Successfully" });
    } else {
      res
        .status(401)
        .json({ isLogin: false, message: "login/invalid-phone-or-password" });
    }
  } catch (error) {
    console.log(error);
    res.status(500).json({ isLogin: false, error: error });
  }
};

const loginWithMobileNumber = async (req, res) => {
  try {
    const { phone } = req.body;
    const userLogin = await User.findOne({ phone: phone });
    if (!userLogin) {
      return res.status(401).json({ isLogin: false });
    }
    const token = await userLogin.generateAuthToken();
    res.cookie("auth_token", token, {
      maxAge: 2629800000,
      httpOnly: true,
    });
    res.json({ isLogin: true, message: "User Login Successfully" });
  } catch (error) {
    res.status(500).json({ isLogin: false, error: error });
  }
};

const logout = async (req, res) => {
  try {
    const token = req.cookies.auth_token;
    if (token) {
      const verifyToken = jwt.verify(token, process.env.SECRET_KEY);
      const userInfo = await User.findOne({ _id: verifyToken._id });

      //Delete token from database
      userInfo.tokens = userInfo.tokens.filter(
        (dbToken) => dbToken.token !== token
      );

      await userInfo.save();
      res.clearCookie("auth_token", { path: "/" });

      res.status(200).json({
        code: 200,
        isLogout: true,
      });
    } else {
      res.status(401).json({
        code: 401,
        isLogout: false,
      });
    }
  } catch (error) {
    res.status(500).json({
      code: 500,
      isLogout: false,
    });
  }
};
const updateUserInfo = async (req, res) => {
  const { id, fname, lname, gender } = req.body;
  try {
    await User.updateOne({ _id: id }, { fname, lname, gender });
    res.status(200).json({
      isUpdated: true,
    });
  } catch (error) {
    console.log(error);
    res.status(500).json({
      code: 500,
      isUpdated: false,
    });
  }
};

const updateEmail = async (req, res) => {
  const { id, email } = req.body;
  try {
    await User.updateOne({ _id: id }, { email });
    res.status(200).json({
      isUpdated: true,
    });
  } catch (error) {
    console.log(error);
    res.status(500).json({
      code: 500,
      isUpdated: false,
    });
  }
};

module.exports = {
  signup,
  login,
  logout,
  loginWithMobileNumber,
  isExistPhone,
  authentication,
  updateUserInfo,
  updateEmail,
};
