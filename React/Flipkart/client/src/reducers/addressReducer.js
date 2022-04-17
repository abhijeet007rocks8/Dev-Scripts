import * as actionType from "../action-type/addressActionType";

const initialState = {
  openAddAddress: false,
  addresses: [],
};

const addressReducer = (state = initialState, action) => {
  switch (action.type) {
    case actionType.UPDATE_ADDRESS_COMPONENT_STATE:
      return { ...state, openAddAddress: action.payload.newState };
    case actionType.ADD_NEW_ADDRESS:
      return {
        ...state,
        addresses: [...state.addresses, action.payload.address],
      };
    case actionType.SET_ADDRESSES:
      return {
        ...state,
        addresses: action.payload.addresses,
      };
    case actionType.REMOVE_ADDRESS:
      return {
        ...state,
        addresses: state.addresses.filter(
          (address) => address._id !== action.payload.addressId
        ),
      };
    default:
      return state;
  }
};

export default addressReducer;
