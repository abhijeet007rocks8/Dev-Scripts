import firebaseApp from "../adapters/firebase";
import {
  getAuth,
  RecaptchaVerifier,
  signInWithPhoneNumber,
} from "firebase/auth";

const sendOtp = async (phoneNumber) => {
  const auth = getAuth();
  phoneNumber = "+91" + phoneNumber;
  window.recaptchaVerifier = new RecaptchaVerifier(
    "sign-in-button",
    {
      size: "invisible",
      callback: (response) => {},
      defaultCountry: "IN",
    },
    auth
  );
  const appVerifier = window.recaptchaVerifier;
  try {
    const confirmationResult = await signInWithPhoneNumber(
      auth,
      phoneNumber,
      appVerifier
    );
    return confirmationResult;
  } catch (error) {
    throw error;
  }
};

export default sendOtp;
