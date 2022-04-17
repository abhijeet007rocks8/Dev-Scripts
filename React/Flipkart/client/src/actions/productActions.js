import * as actionType from "../action-type/productActionType";
import axios from "axios";

export const getProducts = () => async (dispatch) => {
  try {
    const { data } = await axios.get("/products/get-products");
    dispatch({
      type: actionType.GET_PRODUCTS,
      payload: {
        products: data,
      },
    });
  } catch (error) {}
};

export const getProductById = (id) => async (dispatch) => {
  try {
    const { data } = await axios.get(`/products/get-product/${id}`);
    dispatch({
      type: actionType.GET_PRODUCT_BY_ID,
      payload: {
        product: data,
      },
    });
  } catch (error) {}
};

export const getProductsByCategory = async(name) => {
  try {
    const { data } = await axios.get(`/products/get-products/${name}`);
    return data;
  } catch (error) {
    console.log(error);
    return null;
  }
};
