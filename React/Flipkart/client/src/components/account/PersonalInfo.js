import React, { useEffect, useRef, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import axios from "axios";
import {
  Box,
  Button,
  makeStyles,
  TextField,
  Typography,
} from "@material-ui/core";
import Radio from "@material-ui/core/Radio";
import RadioGroup from "@material-ui/core/RadioGroup";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import FormControl from "@material-ui/core/FormControl";

import { updateEmail, updateUserInfo } from "../../actions/userActions";
import toastMessage from "../../utils/toastMessage";

import { makeCapitalizeText } from "../../utils/makeCapitalizeText";

const useStyles = makeStyles((theme) => ({
  component: {
    padding: "30px 40px 0 40px",
  },
  form: {
    display: "flex",
    alignItems: "flex-start",
    margin: "20px 0",
  },
  saveBtn: {
    width: "150px",
    padding: "12px",
    color: "rgb(255, 255, 255)",
    borderRadius: "3px",
    fontSize: "16px",
    boxShadow: "none",
  },
  input: {
    width: "270px",
    fontSize: "14px",
    outline: "none",
    borderRadius: "2px",
    boxShadow: "none",
    marginRight: 10,
  },
  title: {
    fontSize: "18px",
    fontWeight: 600,
    paddingRight: "24px",
    display: "inline-block",
  },
  editLink: {
    display: "inline-block",
    fontSize: "14px",
    fontWeight: 500,
    color: "#2874f0",
    cursor: "pointer",
  },
}));

function PersonalInfo() {
  const [isEditPInfo, setIsEditPInfo] = useState(false);
  const [isEditEmail, setIsEditEmail] = useState(false);
  const { user } = useSelector((state) => state.userReducer);

  const [values, setValues] = useState({
    fname: user.fname,
    lname: user.lname,
    gender: user.gender,
    phone: user.phone,
    email: user.email,
  });

  const [errors, setErrors] = useState({
    fname: false,
    lname: false,
    email: false,
    phone: false,
  });

  const [errorMsg, setErrorMsg] = useState({
    fName: "",
    lName: "",
    phone: "",
    email: "",
  });

  //hooks
  const classes = useStyles();
  const initial = useRef(true);
  const dispatch = useDispatch();

  //Save Counter
  const [saveCountPInfo, setSaveCountPInfo] = useState(0);
  const [saveCountEmail, setSaveCountEmail] = useState(0);

  useEffect(() => {
    if (initial.current === false) {
      if (!errors.fname && !errors.lname) {
        axios
          .patch("/accounts/update-user-info", {
            id: user._id,
            fname: makeCapitalizeText(values.fname),
            lname: makeCapitalizeText(values.lname),
            gender: values.gender,
          })
          .then(() => {
            dispatch(
              updateUserInfo(
                makeCapitalizeText(values.fname),
                makeCapitalizeText(values.lname),
                values.gender
              )
            );
            toastMessage("Account details updated !", "success");
          })
          .catch((e) => {
            toastMessage("Something went wrong.", "error");
          });
        setIsEditPInfo(false);
      }
    }
  }, [saveCountPInfo]);

  useEffect(() => {
    if (initial.current === true) {
      initial.current = false;
    } else {
      if (!errors.email) {
        axios
          .patch("/accounts/update-email", {
            id: user._id,
            email: values.email,
          })
          .then(() => {
            dispatch(updateEmail(values.email));
            toastMessage("Email Address updated !", "success");
          })
          .catch((e) => {
            toastMessage("Something went wrong.", "error");
          });
        setIsEditEmail(false);
      }
    }
  }, [saveCountEmail]);

  //reg for name

  const regName = /^[a-zA-Z]+$/;
  const regEmail =
    /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

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

  const validateEmail = (email) => {
    if (email === "") {
      return {
        isError: true,
        errorMsg: `Email address can not be empty`,
      };
    } else if (!regEmail.test(email)) {
      return {
        isError: true,
        errorMsg: `Please enter valid email`,
      };
    } else {
      return {
        isError: false,
        errorMsg: "",
      };
    }
  };

  const handleChange = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value });
  };

  const savePersonalInfo = () => {
    const validatedFName = validateName(values.fname, "First Name");
    const validatedLName = validateName(values.lname, "Last Name");

    //Set Error
    setErrorMsg({
      ...errorMsg,
      fname: validatedFName.errorMsg,
      lname: validatedLName.errorMsg,
    });

    setErrors({
      ...errors,
      fname: validatedFName.isError,
      lname: validatedLName.isError,
    });
    setSaveCountPInfo((cnt) => cnt + 1);
    //checkout useEffect
  };

  const saveEmail = () => {
    const validatedEmail = validateEmail(values.email);

    //Set Error
    setErrorMsg({
      ...errorMsg,
      email: validatedEmail.errorMsg,
    });

    setErrors({
      ...errors,
      email: validatedEmail.isError,
    });
    setSaveCountEmail((cnt) => cnt + 1);
    //checkout useEffect
  };

  return (
    <>
      <Box className={classes.component}>
        <Typography className={classes.title}>Personal Information</Typography>
        <span
          className={classes.editLink}
          onClick={() => setIsEditPInfo(!isEditPInfo)}
        >
          {isEditPInfo ? "Cancel" : "Edit"}
        </span>
        <Box className={classes.form}>
          <TextField
            label={isEditPInfo ? "First Name" : ""}
            placeholder="First Name"
            variant="outlined"
            className={classes.input}
            value={values.fname}
            name="fname"
            disabled={!isEditPInfo}
            onChange={handleChange}
            error={errors.fname}
            helperText={errors.fname && isEditPInfo && `${errorMsg.fname}`}
          />
          <TextField
            label={isEditPInfo ? "Last Name" : ""}
            placeholder="Last Name"
            variant="outlined"
            className={classes.input}
            value={values.lname}
            name="lname"
            disabled={!isEditPInfo}
            onChange={handleChange}
            error={errors.lname}
            helperText={errors.lname && isEditPInfo && `${errorMsg.lname}`}
          />
          {isEditPInfo && (
            <Button
              variant="contained"
              className={classes.saveBtn}
              style={{ background: "#2874f0" }}
              onClick={savePersonalInfo}
            >
              SAVE
            </Button>
          )}
        </Box>
        <FormControl component="fieldset">
          <Typography style={{ fontSize: 14 }}>Your Gender</Typography>
          <RadioGroup
            row
            aria-label="gender"
            name="gender"
            value={values.gender}
            onChange={handleChange}
          >
            <FormControlLabel
              value="M"
              control={<Radio style={{ color: "#2874f0" }} />}
              label="Male"
              disabled={!isEditPInfo}
            />
            <FormControlLabel
              value="F"
              control={<Radio style={{ color: "#2874f0" }} />}
              label="Female"
              disabled={!isEditPInfo}
            />
          </RadioGroup>
        </FormControl>
        <br />
        <Typography className={classes.title} style={{ marginTop: 50 }}>
          Email Address
        </Typography>
        <span
          className={classes.editLink}
          onClick={() => setIsEditEmail(!isEditEmail)}
        >
          {isEditEmail ? "Cancel" : "Edit"}
        </span>

        <Box className={classes.form}>
          <TextField
            label={isEditEmail ? "Email Address" : ""}
            variant="outlined"
            className={classes.input}
            value={values.email}
            name="email"
            placeholder="Email Address"
            disabled={!isEditEmail}
            onChange={handleChange}
            error={errors.email}
            helperText={errors.email && isEditEmail && `${errorMsg.email}`}
          />
          {isEditEmail && (
            <Button
              variant="contained"
              className={classes.saveBtn}
              style={{ background: "#2874f0" }}
              onClick={saveEmail}
            >
              SAVE
            </Button>
          )}
        </Box>
        <br />
        <Typography className={classes.title} style={{ marginTop: 10 }}>
          Mobile Number
        </Typography>
        {/* <span
          className={classes.editLink}
          onClick={() => setIsEditEmail(!isEditEmail)}
        >
          {isEditEmail ? "Cancel" : "Edit"}
        </span> */}

        <Box className={classes.form}>
          <TextField
            /*  label={isEditEmail ? "Email Address" : ""} */
            variant="outlined"
            disabled
            className={classes.input}
            name="phone"
            value={values.phone}
            /*    disabled={!isEditEmail} */
          />
          {/*  {isEditEmail && (
            <Button
              variant="contained"
              className={classes.saveBtn}
              style={{ background: "#2874f0" }}
            >
              SAVE
            </Button>
          )} */}
        </Box>
        <Box>
          <div style={{ margin: "50px 0" }}>
            <div style={{ fontSize: 20, fontWeight: 600, marginBottom: 20 }}>
              FAQs
            </div>
            <div>
              <h4>
                What happens when I update my email address (or mobile number)?
              </h4>
              <p>
                Your login email id (or mobile number) changes, likewise. You'll
                receive all your account related communication on your updated
                email address (or mobile number).
              </p>
              <br />
              <h4>
                When will my Flipkart account be updated with the new email
                address (or mobile number)?
              </h4>
              <p>
                It happens as soon as you confirm the verification code sent to
                your email (or mobile) and save the changes.
              </p>
              <br />
              <h4>
                What happens to my existing Flipkart account when I update my
                email address (or mobile number)?
              </h4>
              <p>
                Updating your email address (or mobile number) doesn't
                invalidate your account. Your account remains fully functional.
                You'll continue seeing your Order history, saved information and
                personal details.
              </p>
              <br />
              <h4>
                Does my Seller account get affected when I update my email
                address?
              </h4>
              <p>
                Flipkart has a 'single sign-on' policy. Any changes will reflect
                in your Seller account also.
              </p>
            </div>
          </div>
        </Box>
      </Box>
      <img
        width="100%"
        height="auto"
        style={{ verticalAlign: "middle" }}
        src="/myProfileFooter.png"
      />
    </>
  );
}

export default PersonalInfo;
