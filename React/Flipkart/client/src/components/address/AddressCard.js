import React, { useState } from "react";
import clsx from "clsx";
import { Box, makeStyles, Menu, MenuItem, Typography } from "@material-ui/core";
import MoreVertIcon from "@material-ui/icons/MoreVert";
import { useDispatch } from "react-redux";
import { deleteAddress } from "../../actions/addressActions";
import toastMessage from "../../utils/toastMessage";

const useStyles = makeStyles((theme) => ({
  card: {
    color: "#2874f0",
    padding: "16px",
    border: "1px solid #e0e0e0",
    background: "#fff",
    borderRadius: "2px",
    margin: "30px 0",
  },
  addressCard: {
    display: "flex",
    alignItems: "start",
    justifyContent: "space-between",
    fontSize: 14,
  },
  text: {
    fontSize: 14,
    color: "#212121",
    marginTop: 10,
    maxWidth: "90%",
  },
  label: {
    display: "inline-block",
    textTransform: "uppercase",
    fontSize: "11px",
    color: "#878787",
    verticalAlign: "middle",
    padding: "4px 7px",
    borderRadius: "2px",
    backgroundColor: "#f0f0f0",
    fontWeight: 500,
    marginBottom: 5,
  },
  menuItem: {
    fontSize: 14,
  },
}));

function AddressCard({ address, isCheckout = false }) {
  const [anchorEl, setAnchorEl] = useState(null);
  const classes = useStyles();
  const dispatch = useDispatch();

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = (e) => {
    if (e.target.id === "delete") {
      dispatch(deleteAddress(address._id));
      toastMessage("Your address has been deleted successfully!", "success");
    }
    setAnchorEl(null);
  };

  return (
    <>
      <Box
        className={
          isCheckout
            ? classes.addressCard
            : clsx(classes.card, classes.addressCard)
        }
        style={isCheckout ? { marginTop: 20 } : {}}
      >
        <Box>
          {!isCheckout && (
            <span className={classes.label}>
              {address.addressType === "H" ? "Home" : "Work"}
            </span>
          )}
          <Typography className={classes.text} style={{ fontWeight: 600 }}>
            {address.name}
            {isCheckout && (
              <span style={{ margin: "0 15px" }} className={classes.label}>
                {address.addressType === "H" ? "Home" : "Work"}
              </span>
            )}
            <span style={{ marginLeft: 10 }}>{address.number}</span>
          </Typography>
          <Typography className={classes.text}>
            {address.houseAddress}, {address.locality}, {address.city},{" "}
            {address.state} - 
            <span style={{ fontWeight: 600 }}> {address.pincode}</span>
          </Typography>
        </Box>
        {!isCheckout && (
          <Box>
            <MoreVertIcon
              style={{ color: "#212121", opacity: 0.6, cursor: "pointer" }}
              aria-controls="address-menu"
              aria-haspopup="true"
              onClick={handleClick}
            />
            <Menu
              id="address-menu"
              anchorEl={anchorEl}
              keepMounted
              open={Boolean(anchorEl)}
              onClose={handleClose}
              anchorOrigin={{
                vertical: "bottom",
                horizontal: "center",
              }}
              transformOrigin={{
                vertical: "top",
                horizontal: "center",
              }}
            >
              <MenuItem
                id="edit"
                className={classes.menuItem}
                onClick={handleClose}
              >
                Edit
              </MenuItem>
              <MenuItem
                id="delete"
                className={classes.menuItem}
                onClick={handleClose}
              >
                Delete
              </MenuItem>
            </Menu>
          </Box>
        )}
      </Box>
    </>
  );
}

export default AddressCard;
