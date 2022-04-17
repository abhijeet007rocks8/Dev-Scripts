const mongoose = require("mongoose");
const Address = require("../models/addressSchema");

const addNewAddress = async (req, res) => {
  const uId = mongoose.Types.ObjectId(req.body.userId);
  const newAddress = { ...req.body, userId: uId, isDeleted: false };
  try {
    const address = new Address(newAddress);
    await address.save();
    res.send();
  } catch (error) {
    console.log(error);
    res.status(500).send();
  }
};

const getAddress = async (req, res) => {
  try {
    const uId = mongoose.Types.ObjectId(req.params.id);
    const addresses = await Address.find({ userId: uId, isDeleted: false });
    res.json(addresses);
  } catch (error) {
    console.log(error);
    res.status(500).send();
  }
};

const deleteAddress = async (req, res) => {
  try {
    const addressId = mongoose.Types.ObjectId(req.body.addressId);
    await Address.updateOne({ _id: addressId }, { isDeleted: true });
    res.send();
  } catch (error) {
    console.log(error);
    res.status(204).send();
  }
};

module.exports = { addNewAddress, getAddress, deleteAddress };
