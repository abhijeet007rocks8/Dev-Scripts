import React, { useState } from "react";
import axios from "axios";
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router-dom";

import {
  Box,
  Button,
  FormControl,
  FormControlLabel,
  makeStyles,
  Radio,
  RadioGroup,
  TextField,
  Typography,
} from "@material-ui/core";

import { addNewAddress, updateAddrComState } from "../../actions/addressActions";
import { indianStates } from "../../constants/data";
import toastMessage from "../../utils/toastMessage";


import useQuery from "../../hooks/useQuery";

const useStyles = makeStyles((theme) => ({
  component: {
    padding: 20,
    paddingTop: 5,
    paddingLeft: 10,
    cursor: "auto",
  },
  input: {
    backgroundColor: "#fff",
    margin: "8px 5px",
    minWidth: 280,
  },
  title: {
    marginLeft: 5,
    marginBottom: 10,
    fontWeight: 600,
    fontSize: 14,
  },
  radio: {
    margin: "10px 0px 20px 5px",
    fontSize: 16,
    color: "#000",
  },
  saveBtn: {
    width: "230px",
    padding: "10px 20px",
    fontSize: 14,
    color: "rgb(255, 255, 255)",
    borderRadius: "3px",
    fontSize: "16px",
    boxShadow: "none",
  },
  cancelText: {
    fontWeight: 600,
    marginLeft: 50,
    textTransform: "uppercase",
    cursor: "pointer",
  },
  grayText: {
    fontSize: 12,
    color: "#878787",
  },
}));

function AddAddress() {
  const [indianState, setIndianState] = useState("Gujarat");
  const { user } = useSelector((state) => state.userReducer);
  const [values, setValues] = useState({
    name: "",
    number: "",
    pincode: "",
    locality: "",
    houseAddress: "",
    city: "",
    yourState: "Gujarat",
    landmark: "",
    alternateNumber: "",
    addressType: "",
  });

  const classes = useStyles();
  const dispatch = useDispatch();
  const history = useHistory();
  const query = useQuery();

  const handleDropDown = (event) => {
    setIndianState(event.target.value);
  };

  const handleInputs = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value });
  };

  const handleFormSubmit = async (e) => {
    e.preventDefault();
    const newAddressInputs = {
      userId: user._id,
      name: values.name,
      number: values.number,
      pincode: values.pincode,
      locality: values.locality,
      houseAddress: values.houseAddress,
      city: values.city,
      state: values.yourState,
      landmark: values.landmark,
      alternateNumber: values.alternateNumber,
      addressType: values.addressType,
    };
    try {
      await axios.post("/address/add-address", newAddressInputs);
      await dispatch(addNewAddress(newAddressInputs));
      toastMessage("New Address added", "success");
      dispatch(updateAddrComState(false));
      
      //If request Come from checkout
      if (query.get("ref")) {
        let routeString = query.get("ref");
        history.push(`/${routeString}`);
      }
    } catch (error) {
      toastMessage("Something went wrong", "error");
      dispatch(updateAddrComState(false));
    }
  };
  return (
    <Box className={classes.component}>
      <Typography className={classes.title}>ADD A NEW ADDRESS</Typography>
      <form onSubmit={handleFormSubmit}>
        <div>
          <TextField
            id="outlined-name-input"
            className={classes.input}
            label="Name"
            type="text"
            variant="outlined"
            required
            name="name"
            value={values.name}
            onChange={handleInputs}
          />
          <TextField
            id="outlined-number-input"
            className={classes.input}
            label="10 digit mobile number"
            type="text"
            variant="outlined"
            required
            name="number"
            value={values.number}
            onChange={handleInputs}
          />
        </div>
        <div>
          <TextField
            id="outlined-pincode-input"
            className={classes.input}
            label="Pincode"
            type="text"
            variant="outlined"
            required
            name="pincode"
            value={values.pincode}
            onChange={handleInputs}
          />
          <TextField
            id="outlined-locality-input"
            className={classes.input}
            label="locality"
            type="text"
            variant="outlined"
            required
            name="locality"
            value={values.locality}
            onChange={handleInputs}
          />
        </div>
        <div>
          <TextField
            id="outlined-area-static"
            className={classes.input}
            style={{ width: 570 }}
            label="Address (Area & street)"
            multiline
            rows={4}
            variant="outlined"
            required
            name="houseAddress"
            value={values.houseAddress}
            onChange={handleInputs}
          />
        </div>
        <div>
          <TextField
            id="outlined-city-input"
            className={classes.input}
            label="City/District/Town"
            type="text"
            variant="outlined"
            required
            name="city"
            value={values.city}
            onChange={handleInputs}
          />
          <TextField
            id="outlined-select-currency-native"
            className={classes.input}
            select
            label="State"
            value={indianState}
            onChange={handleDropDown}
            SelectProps={{
              native: true,
            }}
            helperText="Please select your State"
            variant="outlined"
            required
            name="yourState"
            value={values.yourState}
            onChange={handleInputs}
          >
            {indianStates.map((option) => (
              <option key={option.value} value={option.value}>
                {option.label}
              </option>
            ))}
          </TextField>
        </div>
        <div>
          <TextField
            id="outlined-Landmark-input"
            className={classes.input}
            label="Landmark (Optional)"
            type="text"
            variant="outlined"
            name="landmark"
            value={values.landmark}
            onChange={handleInputs}
          />
          <TextField
            id="outlined-alternate-input"
            className={classes.input}
            label="Alternate Phone (Optional)"
            type="text"
            variant="outlined"
            name="alternateNumber"
            value={values.alternateNumber}
            onChange={handleInputs}
          />
        </div>
        <FormControl className={classes.radio} component="fieldset">
          <Typography className={classes.grayText} style={{ fontSize: 14 }}>
            Address Type
          </Typography>
          <RadioGroup
            row
            aria-label="type"
            name="addressType"
            value={values.addressType}
            onChange={handleInputs}
          >
            <FormControlLabel
              value="H"
              control={<Radio required style={{ color: "#2874f0" }} />}
              label="Home"
            />
            <FormControlLabel
              value="W"
              control={<Radio required style={{ color: "#2874f0" }} />}
              label="Work"
            />
          </RadioGroup>
        </FormControl>
        <br />
        <Button
          type="submit"
          variant="contained"
          className={classes.saveBtn}
          style={{ background: "#2874f0" }}
        >
          SAVE
        </Button>
        <span
          className={classes.cancelText}
          onClick={() => dispatch(updateAddrComState(false))}
        >
          Cancel
        </span>
      </form>
    </Box>
  );
}

export default AddAddress;
