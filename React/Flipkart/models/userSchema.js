const mongoose = require("mongoose");
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");

const userSchema = mongoose.Schema({
  fname: {
    type: String,
    required: true,
  },
  lname: {
    type: String,
    required: true,
  },
  password: {
    type: String,
    required: true,
  },
  phone: {
    type: Number,
    require: true,
    unique: true,
  },
  gender: String,
  email: String,
  tokens: [
    {
      token: {
        type: String,
      },
    },
  ],
});

userSchema.methods.generateAuthToken = async function () {
  try {
    //create Token
    const token = jwt.sign(
      { _id: this._id.toString() },
      process.env.SECRET_KEY
    );

    //Store created token into database
    this.tokens = this.tokens.concat([{ token: token }]);
    await this.save();
    return token;
  } catch (error) {
    throw error;
  }
};

userSchema.pre("save", async function (next) {
  if (this.isModified("password")) {
    try {
      this.password = await bcrypt.hash(this.password, 12);
    } catch (error) {
      throw error;
    }
  }
  next();
});

const User = new mongoose.model("user", userSchema);

module.exports = User;
