import * as actionType from "../action-type/orderActionType";

const initialState = {
  orderItems: [],
  addressId: "",
  totalAmount: 0,
  orderDetails: [],
};

const orderReducer = (state = initialState, action) => {
  switch (action.type) {
    case actionType.SET_ORDER_ITEMS:
      return { ...state, orderItems: action.payload.orderItems };
    case actionType.GET_ORDER_DETAILS:
      return { ...state, orderDetails: action.payload.details };
    case actionType.SET_TOTAL_AMOUNT:
      return { ...state, totalAmount: action.payload.price };
    default:
      return state;
  }
};

export default orderReducer;
