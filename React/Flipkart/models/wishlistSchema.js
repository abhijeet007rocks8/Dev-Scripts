const mongoose = require("mongoose");

const wishlistSchema = mongoose.Schema({
  userId: {
    type: mongoose.Schema.ObjectId,
    required: true,
  },
  productId: {
    type: mongoose.Schema.ObjectId,
    required: true,
  },
});

const Wishlist = new mongoose.model("wishlist", wishlistSchema, "wishlist");

module.exports = Wishlist;
