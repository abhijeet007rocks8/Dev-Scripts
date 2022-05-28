import React from "react";

import styled from "styled-components";
import Popover from "@mui/material/Popover";

import Avatar, { GreenDotWrapper } from "./Avatar";
import InvisibleSubmitButton from "./InvisibleSubmitButton";

const StyledPopover = styled(Popover)`
  & .MuiPopover-paper {
    border-radius: 8px;
    background-color: var(--background-floating);
    transition-duration: 0s !important;
  }
`;

const Banner = styled.div`
  background-color: ${(p) => p.bgColor};
  width: 300px;
  height: 60px;
`;

const AvatarWrapper = styled.div`
  position: absolute;
  top: 16px;
  left: 16px;

  & ${GreenDotWrapper} {
    padding: 0px;
    font-size: 28px;
    height: 30px;
    width: 30px;
    right: -2px;
    bottom: 2px;
    background-color: var(--background-floating);
  }
`;

const Header = styled.div`
  padding: 64px 16px 16px;
  overflow: hidden;
  position: relative;
  display: block;
`;

const Divider = styled.div`
  height: 1px;
  background-color: var(--background-modifier-accent);
  margin-bottom: 12px;
`;

const Content = styled.div`
  padding: 0 16px 16px 16px;
`;

const Username = styled.span`
  color: var(--interactive-active);
  font-weight: 600;
  font-size: 24px;
`;

const Footer = styled.div`
  padding: 0 16px 16px;
`;

const Note = styled.div`
  font-size: 13px;
  color: var(--text-normal);
  padding-bottom: 8px;
`;

const Input = styled.input`
  background-color: var(--background-secondary-alt);
  font-size: 14px;
  padding: 10px;
  height: 40px;
  width: 100%;
  border-radius: 3px;
  border: 1px solid var(--background-secondary-alt);
  outline: none;
  color: var(--text-muted);
  transition: border-color 0.2s ease-in-out;

  &:focus {
    outline: none;
    border: 1px solid #00b0f4;
  }
`;

const UserPopover = ({ user, setShowPopover, ...delegated }) => {
  const handleSubmit = (event) => {
    event.preventDefault();
    const content = event.target.content.value;
    if (content !== "") {
      event.target.reset();
      setShowPopover(false);
    }
  };

  return (
    <StyledPopover {...delegated}>
      <Banner bgColor={user.avatarColor}></Banner>
      <AvatarWrapper>
        <Avatar
          size="52px"
          w="90px"
          border="6px solid var(--background-floating)"
          bgColor={user.avatarColor}
        />
      </AvatarWrapper>
      <Header>
        <Username>{user.username}</Username>
      </Header>
      <Content>
        <Divider></Divider>
      </Content>
      <Footer>
        <Note>Direct messaging is not implemented!</Note>
        <form onSubmit={handleSubmit}>
          <Input
            type="text"
            name="content"
            placeholder={`message @${user.username}`}
          />
          <InvisibleSubmitButton />
        </form>
      </Footer>
    </StyledPopover>
  );
};

export default UserPopover;
