import React from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  makeStyles,
  Box,
  Badge,
  ListItemIcon,
  ListItemText,
  List,
  ListItem,
} from "@material-ui/core";
import ShoppingCartIcon from "@material-ui/icons/ShoppingCart";
import ExitToAppIcon from "@material-ui/icons/ExitToApp";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import FavoriteIcon from "@material-ui/icons/Favorite";
import HomeIcon from "@material-ui/icons/Home";
import PowerSettingsNewIcon from "@material-ui/icons/PowerSettingsNew";
import { Link } from "react-router-dom";
import { setIsAuthenticate, setUserInfo } from "../../actions/userActions";
import { clearCart } from "../../actions/cartActions";
import axios from "axios";
import toastMessage from "../../utils/toastMessage";

const useStyle = makeStyles((theme) => ({
  list: {
    paddingTop: 30,
    display: "none",
    width: "50vw",
    [theme.breakpoints.down("md")]: {
      display: "block",
    },
  },
  listItem: {
    color: "#0000",
  },
  icon: {
    color: "#2874f0",
  },
  text: {
    color: "#0C0C0C",
    width: 500,
  },
  badge: {
    display: "inline-block",
    marginRight: "10%",
  },
}));

const ListMenu = ({ handleClose }) => {
  const classes = useStyle();
  const { isAuthenticate } = useSelector((state) => state.userReducer);
  const { cartItems } = useSelector((state) => state.cartReducer);
  const { wishlistItems } = useSelector((state) => state.wishlistReducer);
  const dispatch = useDispatch();

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

  return (
    <Box className={classes.list} onClick={handleClose}>
      <List>
        <Link to="/">
          <ListItem button>
            <ListItemIcon className={classes.icon}>
              <HomeIcon />
            </ListItemIcon>
            <ListItemText className={classes.text}>Home</ListItemText>
          </ListItem>
        </Link>
        {!isAuthenticate && (
          <Link to="/login">
            <ListItem button className={classes.listItem}>
              <ListItemIcon className={classes.icon}>
                <ExitToAppIcon />
              </ListItemIcon>
              <ListItemText className={classes.text}>Login</ListItemText>
            </ListItem>
          </Link>
        )}
        {isAuthenticate && (
          <>
            <Link to="/account">
              <ListItem button>
                <ListItemIcon className={classes.icon}>
                  <AccountCircleIcon />
                </ListItemIcon>
                <ListItemText className={classes.text}>My Account</ListItemText>
              </ListItem>
            </Link>
            <Link to="/orders">
              <ListItem button>
                <ListItemIcon>
                  <img
                    src="/order-icon.svg"
                    style={{ marginRight: 15 }}
                    className={classes.icon}
                  />
                </ListItemIcon>
                <ListItemText className={classes.text}>Orders</ListItemText>
              </ListItem>
            </Link>
            <Link to="/wishlist">
              <ListItem button>
                <ListItemIcon className={classes.icon}>
                  <FavoriteIcon />
                </ListItemIcon>
                <ListItemText className={classes.text}>Wishlist</ListItemText>
                {wishlistItems.length > 0 && (
                  <Badge
                    badgeContent={wishlistItems.length}
                    color="secondary"
                    className={classes.badge}
                  />
                )}
              </ListItem>
            </Link>
          </>
        )}
        <Link to="/cart">
          <ListItem button>
            <ListItemIcon className={classes.icon}>
              <ShoppingCartIcon />
            </ListItemIcon>
            <ListItemText className={classes.text}>Cart</ListItemText>
            {cartItems.length > 0 && (
              <Badge
                badgeContent={cartItems.length}
                color="secondary"
                className={classes.badge}
              />
            )}
          </ListItem>
        </Link>
        {isAuthenticate && (
          <ListItem button onClick={logout}>
            <ListItemIcon className={classes.icon}>
              <PowerSettingsNewIcon />
            </ListItemIcon>
            <ListItemText>Logout</ListItemText>
          </ListItem>
        )}
      </List>
    </Box>
  );
};

export default ListMenu;
