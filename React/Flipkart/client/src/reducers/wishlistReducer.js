import * as actionType from "../action-type/wishlistActionType";

const initialState = {
  wishlistItems: [],
};

const wishlistReducer = (state = initialState, action) => {
  switch (action.type) {
    case actionType.ADD_TO_WISHLIST:
      const item = action.payload.item;
      const isExist = state.wishlistItems.find(
        (product) => product._id === item._id
      );

      if (isExist) {
        return state;
      } else {
        return { ...state, wishlistItems: [...state.wishlistItems, item] };
      }

    case actionType.REMOVE_FROM_WISHLIST:
      return {
        ...state,
        wishlistItems: state.wishlistItems.filter(
          (product) => product._id !== action.payload.id
        ),
      };

    case actionType.SET_WISHLIST_ITEMS:
      return {
        ...state,
        wishlistItems: action.payload.wishlistItems,
      };
    default:
      return state;
  }
};

export default wishlistReducer;
