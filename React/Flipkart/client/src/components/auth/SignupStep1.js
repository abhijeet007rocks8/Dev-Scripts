import React, { useEffect, useRef, useState } from "react";
import { useDispatch } from "react-redux";
import axios from "axios";

import { makeStyles } from "@material-ui/core/styles";
import InputAdornment from "@material-ui/core/InputAdornment";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import CircularProgress from "@material-ui/core/CircularProgress";

import sendOTP from "../../utils/sendOTP";
import { setMobileNumber, setOTPResult } from "../../actions/userActions";
import { setIsLogin } from "../../actions/userActions";
import toastMessage from "../../utils/toastMessage";


const useStyles = makeStyles((theme) => ({
  signupInputs: {
    margin: "30px 0px 50px 0",
  },
  btn: {
    border: "none",
    textTransform: "capitalize",
    fontWeight: 600,
    padding: "10px 20px",
  },
  para: {
    color: "#878787",
    fontSize: 12,
    fontWeight: 400,
    marginTop: 20,
    marginBottom: 10,
  },
  buttonProgress: {
    color: "white",
    margin: "0 10px",
  },
}));

function SignupStep1({ handleActions }) {
  const [phoneNum, setPhoneNum] = useState({
    value: "",
    isError: false,
    errorMsg: "",
  });
  const [loading, setLoading] = useState(false);
  const [submitCount, setSubmitCount] = useState(0);
  const initial = useRef(true);
  const dispatch = useDispatch();

  useEffect(() => {
    if (initial.current === true) {
      initial.current = false;
    } else {
      if (!phoneNum.isError) {
        submitPhone();
      }
    }
  }, [submitCount]);

  //variables
  const classes = useStyles();
  const regNumeric = /^[0-9\b]+$/;
  const regPhone = /^[6-9]\d{9}$/;

  const submitPhone = async () => {
    setLoading(true);
    try {
      const res = await axios.post("/accounts/check-phone", {
        phone: phoneNum.value,
      });
      const isRegistered = res.data.isExist;
      if (isRegistered) {
        setLoading(false);
        toastMessage("You are already registered. Please login", "info");
      } else {
        const confirmationResult = await sendOTP(phoneNum.value);
        dispatch(setOTPResult(confirmationResult));
        dispatch(setMobileNumber(phoneNum.value));
        setLoading(false);
        handleActions({
          openStep1: false,
          openStep2: false,
          openOTPVerify: true,
        });
      }
    } catch (error) {
      setLoading(false);
      toastMessage("Something went wrong.", "error");
    }
  };

  const numericOnly = (e) => {
    let preval = e.target.value;
    if (
      e.target.value === "" ||
      (regNumeric.test(e.target.value) && e.target.value.length <= 10)
    ) {
      setPhoneNum({ ...phoneNum, value: e.target.value });
    } else {
      e.target.value = preval.substring(0, preval.length - 1);
      setPhoneNum({ ...phoneNum, value: e.target.value });
    }
  };

  const validatePhone = (phoneNumber) => {
    if (phoneNumber === "") {
      return {
        isError: true,
        errorMsg: "Mobile number can not be empty",
      };
    } else if (phoneNumber.length < 10 || !regPhone.test(phoneNumber)) {
      return {
        isError: true,
        errorMsg: "Please enter valid mobile number",
      };
    } else {
      return {
        isError: false,
        errorMsg: "",
      };
    }
  };

  const onSubmit = () => {
    const { isError, errorMsg } = validatePhone(phoneNum.value);
    setPhoneNum({ ...phoneNum, isError: isError, errorMsg: errorMsg });
    setSubmitCount((cnt) => cnt + 1);
  };

  return (
    <>
      <TextField
        error={phoneNum.isError}
        id={
          phoneNum.isError
            ? "standard-error-helper-text"
            : "standard-start-adornment"
        }
        label="Enter Mobile number"
        className={classes.signupInputs}
        InputProps={{
          startAdornment: <InputAdornment position="start">+91</InputAdornment>,
        }}
        onChange={numericOnly}
        value={phoneNum.value}
        name="phone"
        helperText={phoneNum.isError && `${phoneNum.errorMsg}`}
      />
      <Button
        variant="contained"
        className={classes.btn}
        id="sign-in-button"
        style={{ background: "#fb641b", color: "#fff" }}
        color="primary"
        disabled={loading}
        onClick={onSubmit}
      >
        {loading ? (
          <CircularProgress size={24} className={classes.buttonProgress} />
        ) : (
          "CONTINUE"
        )}
      </Button>
      <Button
        variant="contained"
        className={classes.btn}
        style={{
          background: "#fff",
          color: "#2874f0",
          marginTop: "20px",
        }}
        color="primary"
        onClick={() => {
          dispatch(setIsLogin(true));
        }}
      >
        Existing User? Log in
      </Button>
    </>
  );
}

export default SignupStep1;
