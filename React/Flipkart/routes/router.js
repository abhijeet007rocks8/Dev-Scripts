const express = require("express");
const {
  getProducts,
  getProductById,
  addProduct,
  getProductsByCategory,
} = require("../controllers/product-controller");
const {
  addItem,
  removeItem,
  removeAllItem,
  getCartItems,
} = require("../controllers/cart-controller");

const {
  addItem: addItemWishlist,
  removeItem: removeItemWishlist,
  getWishlistItems,
} = require("../controllers/wishlist-controller");

const {
  signup,
  login,
  logout,
  loginWithMobileNumber,
  isExistPhone,
  authentication,
  updateUserInfo,
  updateEmail,
} = require("../controllers/user-controller");

const {
  addNewAddress,
  getAddress,
  deleteAddress,
} = require("../controllers/address-controller");

const {
  completeOrder,
  getOrderDetails,
} = require("../controllers/order-controller");

const {
  paytmGatway,
  paytmDataResponse,
} = require("../controllers/payment-controller");

const router = express.Router();

//User Account related routes

router.post("/accounts/signup", signup);
router.post("/accounts/login", login);
router.post("/accounts/login-with-phone", loginWithMobileNumber);
router.post("/accounts/check-phone", isExistPhone);
router.get("/accounts/authentication", authentication);
router.get("/accounts/logout", logout);
router.patch("/accounts/update-user-info", updateUserInfo);
router.patch("/accounts/update-email", updateEmail);

//Product related routes

router.get("/products/get-products", getProducts);
router.get("/products/get-products/:categoryName", getProductsByCategory);
router.get("/products/get-product/:id", getProductById);
router.get("/products/add-product", addProduct);

//Cart related routes
router.post("/cart/add-item", addItem);
router.delete("/cart/remove-item", removeItem);
router.delete("/cart/clear-cart", removeAllItem);
router.get("/cart/get-items/:id", getCartItems);

//Wishlist related routes
router.post("/wishlist/add-item", addItemWishlist);
router.delete("/wishlist/remove-item", removeItemWishlist);
router.get("/wishlist/get-items/:id", getWishlistItems);

//Address related routes
router.post("/address/add-address", addNewAddress);
router.get("/address/get-addresses/:id", getAddress);
router.delete("/address/delete-address", deleteAddress);

//orders related routes

router.post("/orders/complete-order", completeOrder);
router.post("/orders/get-order-details", getOrderDetails);

//Payment related routes
router.post("/payment/paytm", paytmGatway);
router.post("/payment/paytmresponse", paytmDataResponse);

module.exports = router;
