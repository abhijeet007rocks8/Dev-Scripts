import * as actionType from "../action-type/userActionType";

export const setIsLogin = (isLogin) => ({
  type: actionType.SET_IS_LOGIN,
  payload: {
    isLogin,
  },
});

export const setMobileNumber = (phoneNumber) => ({
  type: actionType.SET_MOBILE_NUMBER,
  payload: {
    phoneNumber,
  },
});

export const setOTPResult = (confirmResult) => ({
  type: actionType.SET_VERIFICATION_CODE,
  payload: {
    confirmResult,
  },
});

export const setIsAuthenticate = (authStatus) => ({
  type: actionType.SET_IS_AUTHENTICATE,
  payload: {
    isAuthenticate: authStatus,
  },
});

export const setUserInfo = (user) => ({
  type: actionType.SET_USER_INFO,
  payload: {
    user,
  },
});

export const setPopupLogin = (isPopup) => ({
  type: actionType.SET_POPUP_LOGIN,
  payload: {
    isPopup,
  },
});

export const updateUserInfo = (fname, lname, gender) => ({
  type: actionType.UPDATE_USER_INFO,
  payload: {
    fname,
    lname,
    gender,
  },
});

export const updateEmail = (email) => ({
  type: actionType.UPDATE_USER_EMAIL,
  payload: {
    email,
  },
});

export const modalOpen = () => ({
  type: actionType.OPEN_MODAL,
  payload: {},
});

export const modalClose = () => ({
  type: actionType.CLOSE_MODAL,
  payload: {},
});
