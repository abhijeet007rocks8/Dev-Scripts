const mongoose = require("mongoose");
const Cart = require("../models/cartSchema");

const addItem = async (req, res) => {
  try {
    const cart = new Cart(req.body);
    await cart.save();
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
    await Cart.deleteOne({ userId: userId, productId: productId });
    res.send();
  } catch (error) {
    console.log(error);
    res.status(204).send();
  }
};

const removeAllItem = async (req, res) => {
  try {
    const userId = mongoose.Types.ObjectId(req.body.userId);
    await Cart.deleteMany({ userId: userId });
    res.send();
  } catch (error) {
    console.log(error);
    res.status(404).json({ error: "CLEAR_CART" });
  }
};

const getCartItems = async (req, res) => {
  try {
    const uId = mongoose.Types.ObjectId(req.params.id);
    const cartItems = await Cart.aggregate([
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
    res.json(cartItems);
  } catch (error) {
    console.log(error);
    res.status(500).send();
  }
};

module.exports = { addItem, getCartItems, removeItem, removeAllItem };
