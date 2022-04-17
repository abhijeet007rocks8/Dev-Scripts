import * as actionType from "../action-type/productActionType";

const initialState = {
  products: [],
  product: {},
};

const productReducer = (state = initialState, action) => {
  switch (action.type) {
    case actionType.GET_PRODUCTS:
      return { ...state, products: action.payload.products };
    case actionType.GET_PRODUCT_BY_ID:
      return { ...state, product: action.payload.product };
    default:
      return state;
  }
};

export default productReducer;
