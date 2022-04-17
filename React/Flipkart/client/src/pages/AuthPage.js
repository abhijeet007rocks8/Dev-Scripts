import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useHistory } from "react-router";
import Backdrop from "@material-ui/core/Backdrop";
import CircularProgress from "@material-ui/core/CircularProgress";
import { makeStyles } from "@material-ui/core/styles";

import { setIsAuthenticate, setUserInfo } from "../actions/userActions";
import authentication from "../adapters/authentication";

import Login from "../components/auth/Login";
import Signup from "../components/auth/Signup";
import ToastMessageContainer from "../components/ToastMessageContainer";

import "../styles/AuthPage.css";

const useStyles = makeStyles((theme) => ({
  backdrop: {
    zIndex: theme.zIndex.drawer + 1,
    color: "#fff",
  },
}));

function AuthPage({ popup = false }) {
  const [isOpen, setIsOpen] = useState(true);
  const { isLogin } = useSelector((state) => state.userReducer);
  const { isAuthenticate } = useSelector((state) => state.userReducer);
  const history = useHistory();
  const dispatch = useDispatch();
  const classes = useStyles();

  useEffect(() => {
    if (!isAuthenticate) {
      setIsOpen(true);
      authentication()
        .then((res) => {
          dispatch(setIsAuthenticate(res.isAuth));
          dispatch(setUserInfo(res.user));
          setIsOpen(false);
          history.push("/");
        })
        .catch((err) => {
          setIsOpen(false);
        });
    }
  }, [isAuthenticate]);

  return (
    <div className={popup ? "login_popup" : "login"}>
      <div className="container_left">
        <div>
          <span className="title">
            {isLogin ? "Login" : "Looks like you're new here!"}
          </span>
          <p className="subtitle">
            {isLogin
              ? "Get access to your Orders, Wishlist and Recommendations"
              : "Sign up with your mobile number to get started"}
          </p>
        </div>
      </div>
      <div className="container_right">{isLogin ? <Login /> : <Signup />}</div>
      <Backdrop className={classes.backdrop} open={isOpen}>
        <CircularProgress color="inherit" />
      </Backdrop>
      <ToastMessageContainer />
    </div>
  );
}

export default AuthPage;
