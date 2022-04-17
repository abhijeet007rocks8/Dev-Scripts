import * as actionType from "../action-type/cartActionType";
import axios from "axios";

export const addToCart = (item) => async (dispatch, getState) => {
  const { isAuthenticate, user } = getState().userReducer;
  const { cartItems } = getState().cartReducer;

  const existItem = cartItems.find((product) => product._id === item._id);

  if (!existItem) {
    if (isAuthenticate) {
      try {
        await axios.post("/cart/add-item", {
          userId: user._id,
          productId: item._id,
        });
      } catch (error) {}
    }
  }
  dispatch({
    type: actionType.ADD_TO_CART,
    payload: {
      item,
    },
  });
};

export const removeFromCart = (id) => async (dispatch, getState) => {
  const { isAuthenticate, user } = getState().userReducer;
  if (isAuthenticate) {
    try {
      await axios.delete("/cart/remove-item", {
        data: {
          userId: user._id,
          productId: id,
        },
      });
    } catch (error) {}
  }
  dispatch({
    type: actionType.REMOVE_FROM_CART,
    payload: {
      id: id,
    },
  });
};

export const clearCart = () => async (dispatch, getState) => {
  const { isAuthenticate, user } = getState().userReducer;

  if (isAuthenticate) {
    try {
      await axios.delete("/cart/clear-cart", {
        data: {
          userId: user._id,
        },
      });
    } catch (error) {}
  }
  dispatch({
    type: actionType.CLEAR_CART,
    payload: {},
  });
};

export const getCartItems = () => async (dispatch, getState) => {
  const { isAuthenticate, user } = getState().userReducer;
  const { cartItems } = getState().cartReducer;

  if (isAuthenticate) {
    try {
      const { data } = await axios.get(`/cart/get-items/${user._id}`);
      console.log(data.length);
      if (data.length > 0) {
        data?.map((value) => {
          var isExist = false;
          cartItems.forEach((item) => {
            if (item._id == value.productDetails[0]._id) {
              isExist = true;
            }
          });
          if (!isExist) {
            cartItems.push(value.productDetails[0]);
          }
        });
        dispatch({
          type: actionType.SET_CART_ITEMS,
          payload: {
            cartItems: cartItems,
          },
        });
      }
    } catch (error) {}
  }
};

export const updateQty = (productId, qty) => {
  return {
    type: actionType.UPDATE_QTY,
    payload: {
      productId,
      qty,
    },
  };
};
