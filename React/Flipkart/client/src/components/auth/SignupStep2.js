import React, { useEffect, useRef, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router-dom";
import axios from "axios";
import clsx from "clsx";
import { makeStyles } from "@material-ui/core/styles";
import IconButton from "@material-ui/core/IconButton";
import Input from "@material-ui/core/Input";
import InputLabel from "@material-ui/core/InputLabel";
import InputAdornment from "@material-ui/core/InputAdornment";
import FormHelperText from "@material-ui/core/FormHelperText";
import FormControl from "@material-ui/core/FormControl";
import TextField from "@material-ui/core/TextField";
import Visibility from "@material-ui/icons/Visibility";
import VisibilityOff from "@material-ui/icons/VisibilityOff";
import Button from "@material-ui/core/Button";
import { CircularProgress } from "@material-ui/core";

import toastMessage from "../../utils/toastMessage";
import authentication from "../../adapters/authentication";
import {
  modalClose,
  setIsAuthenticate,
  setUserInfo,
} from "../../actions/userActions";

import useQuery from "../../hooks/useQuery";
import { makeCapitalizeText } from "../../utils/makeCapitalizeText";

const useStyles = makeStyles((theme) => ({
  signupInputs: {
    margin: "5px 0px 20px 0",
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
    margin: "0px 10px",
  },
}));
function SignupStep2() {
  const [showPassword, setShowPassword] = useState(false);
  const [values, setValues] = useState({
    fName: "",
    lName: "",
    password: "",
  });
  const [errors, setErrors] = useState({
    fName: false,
    lName: false,
    password: false,
  });

  const [errorMsg, setErrorMsg] = useState({
    fName: "",
    lName: "",
    password: "",
  });
  const [loading, setLoading] = useState(false);
  const [submitCount, setSubmitCount] = useState(0);
  const initial = useRef(true);
  const { phoneNumber, popupLogin } = useSelector((state) => state.userReducer);

  useEffect(() => {
    if (initial.current === true) {
      initial.current = false;
    } else {
      let formError = false;
      const errorValues = Object.values(errors);
      errorValues.forEach((value) => {
        if (value) formError = true;
      });
      if (!formError) {
        completeSignup();
      }
    }
  }, [submitCount]);

  const classes = useStyles();
  const dispatch = useDispatch();
  const history = useHistory();
  const query = useQuery();

  const regName = /^[a-zA-Z]+$/;
  const regPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,20}$/;

  const handleClickShowPassword = () => {
    setShowPassword(!showPassword);
  };

  const validateName = (name, fieldName) => {
    if (name === "") {
      return {
        isError: true,
        errorMsg: `${fieldName} can not be empty`,
      };
    } else if (name.length < 3) {
      return {
        isError: true,
        errorMsg: "Minimum 3 charterers required",
      };
    } else if (name.length > 20) {
      return {
        isError: true,
        errorMsg: "Maximum 20 charterers allowed",
      };
    } else if (!regName.test(name)) {
      return {
        isError: true,
        errorMsg: `Invalid ${fieldName}`,
      };
    } else {
      return {
        isError: false,
        errorMsg: "",
      };
    }
  };

  const validatePassword = (pass) => {
    if (pass === "") {
      return {
        isError: true,
        errorMsg: `Password can not be empty`,
      };
    } else if (pass.length < 6) {
      return {
        isError: true,
        errorMsg: "Minimum 6 charterers required",
      };
    } else if (pass.length > 20) {
      return {
        isError: true,
        errorMsg: "Maximum 20 charterers allowed",
      };
    } else if (!regPassword.test(pass)) {
      return {
        isError: true,
        errorMsg: "Week Password !",
      };
    } else {
      return {
        isError: false,
        errorMsg: "",
      };
    }
  };

  const completeSignup = async () => {
    setLoading(true);
    try {
      const res = await axios.post("/accounts/signup", {
        fname: makeCapitalizeText(values.fName),
        lname: makeCapitalizeText(values.lName),
        password: values.password,
        phone: phoneNumber,
      });
      const { isAuth, user } = await authentication();
      dispatch(setIsAuthenticate(isAuth));
      dispatch(setUserInfo(user));

      setLoading(false);

      //Modal Close
      if (popupLogin) {
        dispatch(modalClose());
      }

      if (query.get("ref")) {
        let routeString = query.get("ref");
        history.replace(`/${routeString}`);
      } else {
        history.replace("/");
      }
    } catch (error) {
      setLoading(false);
      toastMessage("Something went wrong. Please sign up later.", "error");
    }
  };

  const handleInputs = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value });
  };

  const submitForm = () => {
    const validatedFName = validateName(values.fName, "First Name");
    const validatedLName = validateName(values.lName, "Last Name");
    const validatedPassword = validatePassword(values.password);

    //Set Error
    setErrorMsg({
      fName: validatedFName.errorMsg,
      lName: validatedLName.errorMsg,
      password: validatedPassword.errorMsg,
    });

    setErrors({
      fName: validatedFName.isError,
      lName: validatedLName.isError,
      password: validatedPassword.isError,
    });
    setSubmitCount((cnt) => cnt + 1);
    //checkout useEffect
  };
  return (
    <>
      <TextField
        id={errors.fName ? "standard-basic" : "standard-start-adornment"}
        label="Enter First Name"
        className={classes.signupInputs}
        value={values.fName}
        onChange={handleInputs}
        name="fName"
        error={errors.fName}
        helperText={errors.fName && `${errorMsg.fName}`}
      />
      <TextField
        id={errors.lName ? "standard-basic" : "standard-start-adornment"}
        label="Enter Last Name"
        className={classes.signupInputs}
        value={values.lName}
        onChange={handleInputs}
        name="lName"
        error={errors.lName}
        helperText={errors.lName && `${errorMsg.lName}`}
      />
      <FormControl
        className={clsx(
          classes.margin,
          classes.textField,
          classes.signupInputs
        )}
        error={errors.password}
      >
        <InputLabel htmlFor="standard-adornment-password">
          Set Password
        </InputLabel>
        <Input
          id={
            errors.password
              ? "standard-adornment-password"
              : "standard-start-adornment"
          }
          type={showPassword ? "text" : "password"}
          onChange={handleInputs}
          value={values.password}
          name="password"
          error={errors.password}
          endAdornment={
            <InputAdornment position="end">
              <IconButton
                aria-label="toggle password visibility"
                onClick={handleClickShowPassword}
              >
                {showPassword ? <Visibility /> : <VisibilityOff />}
              </IconButton>
            </InputAdornment>
          }
        />
        {errors.password && (
          <FormHelperText id="standard-helper-text" error={true}>
            {errorMsg.password}
          </FormHelperText>
        )}
      </FormControl>
      <p className={classes.para}>
        By continuing, you agree to Flipkart's Terms of Use and Privacy Policy.
      </p>
      <Button
        variant="contained"
        className={classes.btn}
        style={{ background: "#fb641b", color: "#fff" }}
        color="primary"
        disabled={loading}
        onClick={submitForm}
      >
        {loading ? (
          <CircularProgress size={24} className={classes.buttonProgress} />
        ) : (
          "Signup"
        )}
      </Button>
    </>
  );
}

export default SignupStep2;
