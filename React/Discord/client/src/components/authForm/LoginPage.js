import React, { useEffect, useState } from "react";

import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router";
import { Link } from "react-router-dom";

import Form from "./Form";
import Input from "./Input";
import Label from "./Label";
import Layout from "./Layout";
import SubmitButton from "./SubmitButton";
import { login, connectSocket } from "../../reducers/sessionReducer";
import { loadChannels } from "../../reducers/channelsReducer";

const LoginPage = () => {
  const [usernameError, setUsernameError] = useState("");
  const [passwordError, setPasswordError] = useState("");

  const dispatch = useDispatch();

  const handleSubmit = (event) => {
    event.preventDefault();
    const username = event.target.username.value;
    const password = event.target.password.value;
    if (!username) {
      setUsernameError("This field is required");
    }
    if (!password) {
      setPasswordError("This field is required");
    }
    if (username && password) {
      dispatch(login({ username, password }));
      setUsernameError("");
      setPasswordError("");
    }
  };

  const navigate = useNavigate();
  const session = useSelector((state) => state.session);
  useEffect(() => {
    if (session.isAuthenticated) {
      dispatch(connectSocket(session.user));
      dispatch(loadChannels());
      navigate("/channels/1");
    }
  }, [dispatch, navigate, session]);

  return (
    <Layout heading="Welcome back!">
      <Form onSubmit={handleSubmit}>
        <span className="errorMessage" style={{ textAlign: "center" }}>
          {session.error}
        </span>
        <Label error={usernameError}>
          Username
          {usernameError && (
            <span className="errorMessage"> - {usernameError}</span>
          )}
        </Label>
        <Input type="text" name="username" error={usernameError} />
        <Label error={passwordError}>
          Password
          {passwordError && (
            <span className="errorMessage"> - {passwordError}</span>
          )}
        </Label>
        <Input type="password" name="password" error={passwordError} />
        <SubmitButton>Login</SubmitButton>
        <div>
          Need an account? <Link to="/">Use a demo account</Link> or{" "}
          <Link to="/signup">Register</Link>
        </div>
      </Form>
    </Layout>
  );
};

export default LoginPage;
