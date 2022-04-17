import { combineReducers } from "redux";
import { persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage";

import userReducer from "./userReducer";
import productReducer from "./productReducer";
import cartReducer from "./cartReducer";
import wishlistReducer from "./wishlistReducer";
import addressReducer from "./addressReducer";
import orderReducer from "./orderReducer";

const persistConfig = {
  key: "root",
  storage,
  whitelist: ["cartReducer","userReducer"],
};


const rootReducer = combineReducers({
  userReducer,
  productReducer,
  cartReducer,
  wishlistReducer,
  addressReducer,
  orderReducer,
});

export default persistReducer(persistConfig, rootReducer);
