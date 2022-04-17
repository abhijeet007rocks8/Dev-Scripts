const mongoose = require("mongoose");
const Wishlist = require("../models/wishlistSchema");

const addItem = async (req, res) => {
  try {
    const wishlist = new Wishlist(req.body);
    await wishlist.save();
    res.send();
  } catch (error) {
    console.log(error);
    res.status(500).send();
  }
};

const removeItem = async (req, res) => {
  try {
    const userId = mongoose.Types.ObjectId(req.body.userId);
    const productId = mongoose.Types.ObjectId(req.body.productId);
    await Wishlist.deleteOne({ userId: userId, productId: productId });
    res.send();
  } catch (error) {
    console.log(error);
    res.status(204).send();
  }
};

const getWishlistItems = async (req, res) => {
  try {
    const uId = mongoose.Types.ObjectId(req.params.id);
    const items = await Wishlist.aggregate([
      {
        $match: {
          userId: uId,
        },
      },
      {
        $lookup: {
          from: "products",
          localField: "productId",
          foreignField: "_id",
          as: "productDetails",
        },
      },
    ]);
    res.json(items);
  } catch (error) {
    console.log(error);
    res.status(500).send();
  }
};

module.exports = { addItem, getWishlistItems, removeItem };
