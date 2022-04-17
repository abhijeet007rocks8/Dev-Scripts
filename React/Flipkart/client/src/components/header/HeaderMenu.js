import React, { useEffect, useState } from "react";
import axios from "axios";
import {
  Button,
  makeStyles,
  Box,
  Typography,
  Badge,
  Dialog,
  DialogContent,
} from "@material-ui/core";
import { Link, useLocation } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import ShoppingCartIcon from "@material-ui/icons/ShoppingCart";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";

import {
  modalClose,
  modalOpen,
  setIsAuthenticate,
  setPopupLogin,
  setUserInfo,
} from "../../actions/userActions";
import authentication from "../../adapters/authentication";
import toastMessage from "../../utils/toastMessage";

import AuthPage from "../../pages/AuthPage";
import ProfileMenu from "./ProfileMenu";
import { clearCart } from "../../actions/cartActions";

const useStyles = makeStyles((theme) => ({
  headerMenu: {
    display: "flex",
    alignItems: "center",
    margin: "0 7% 0 auto",
    "& > *": {
      marginRight: 30,
    },
    [theme.breakpoints.down("md")]: {
      display: "none",
    },
  },
  login_btn: {
    color: "#2874f0",
    marginLeft: "7%",
    fontWeight: 600,
    textTransform: "capitalize",
    cursor: "pointer",
    borderRadius: 2,
    height: 35,
    padding: "5px 35px",
    border: "1px solid #dbdbdb",
    boxShadow: "none",
  },
  menu_link: {
    display: "flex",
  },
  menu_more: {
    fontSize: "1rem",
    fontWeight: 500,
    TextDecoration: "none",
  },
  menu_cart: {
    marginLeft: "5px",
    fontSize: "1rem",
    fontWeight: 500,
    TextDecoration: "none",
  },
}));

function HeaderMenu() {
  const [open, setOpen] = useState(false);

  const { popupLogin, isAuthenticate, isModalOpen } = useSelector(
    (state) => state.userReducer
  );
  const { cartItems } = useSelector((state) => state.cartReducer);

  const location = useLocation();
  const dispatch = useDispatch();
  useEffect(() => {
    if (location.pathname === "/login") {
      dispatch(setPopupLogin(false));
    } else {
      dispatch(setPopupLogin(true));
    }
    if (!isAuthenticate) {
      authentication().then((res) => {
        dispatch(setIsAuthenticate(res.isAuth));
        dispatch(setUserInfo(res.user));
      });
    }
  }, [location.pathname, isAuthenticate]);
  const classes = useStyles();

  const logout = async () => {
    try {
      await axios.get("/accounts/logout", {
        withCredentials: true,
      });
      dispatch(setUserInfo({}));
      dispatch(setIsAuthenticate(false));
      dispatch(clearCart());
      window.location.replace("/");
    } catch (error) {
      toastMessage("Something went wrong. Please try again later", "error");
    }
  };

  const handleClickOpen = () => {
    dispatch(modalOpen());
  };
  const handleClose = () => {
    dispatch(modalClose());
  };

  return (
    <Box className={classes.headerMenu}>
      {isAuthenticate ? (
        <ProfileMenu logout={logout} />
      ) : (
        <Button
          variant="contained"
          style={{ backgroundColor: "#fff" }}
          className={classes.login_btn}
          onClick={() => {
            if (popupLogin) handleClickOpen();
          }}
        >
          Login
        </Button>
      )}

      <Link to="/more">
        <Box className={classes.menu_link}>
          <Typography className={classes.menu_more}>More</Typography>
          <ExpandMoreIcon />
        </Box>
      </Link>
      <Link to="/cart">
        <Box className={classes.menu_link}>
          <ShoppingCartIcon />
          {cartItems.length > 0 && (
            <Badge badgeContent={cartItems.length} color="secondary"></Badge>
          )}
          <Typography className={classes.menu_cart}>Cart</Typography>
        </Box>
      </Link>

      {/* ########## Login Dialog Box  #########*/}
      <Dialog onClose={handleClose} open={isModalOpen}>
        <DialogContent style={{ width: "100%" }}>
          <AuthPage popup={true} />
        </DialogContent>
      </Dialog>

    </Box>
  );
}

export default HeaderMenu;
