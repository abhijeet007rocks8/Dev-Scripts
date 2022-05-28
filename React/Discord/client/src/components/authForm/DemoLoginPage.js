import React, { useEffect } from "react";

import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router";
import { Link } from "react-router-dom";
import styled from "styled-components";

import { login, connectSocket } from "../../reducers/sessionReducer";
import { loadChannels } from "../../reducers/channelsReducer";
import Label from "./Label.js";
import Form from "./Form.js";
import Select from "./Select.js";
import Layout from "./Layout.js";
import SubmitButton from "./SubmitButton.js";

const Description = styled.div`
  color: var(--text-normal);
  margin: 16px 0;
  padding: 8px 0;
`;

const DemoLoginPage = () => {
  const dispatch = useDispatch();

  const handleSubmit = (event) => {
    event.preventDefault();
    const username = event.target.username.value;
    dispatch(login({ username, password: username }));
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
    <Layout heading="Discord Clone">
      <Form onSubmit={handleSubmit}>
        <Description>
          To visitors: You can open this website in multiple tabs and sign in
          with a different account in each tab.
        </Description>
        <span className="errorMessage" style={{ textAlign: "center" }}>
          {session.error}
        </span>
        <Label htmlFor="username">Username</Label>
        <Select name="username" id="username" defaultValue="john.doe">
          <option value="john_doe">johny_done</option>
          <option value="jane_doe">jane_done</option>
          <option value="guest123">guest123</option>
          <option value="programmer">programmer</option>
        </Select>
        <SubmitButton>Login</SubmitButton>
        <div>
          Want your own account? <Link to="/signup">Register</Link>
        </div>
        <div>
          Already have an account? <Link to="/login">Login</Link>
        </div>
      </Form>
    </Layout>
  );
};

export default DemoLoginPage;
