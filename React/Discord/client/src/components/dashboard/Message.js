import React, { useEffect, useState } from "react";

import Modal from "@mui/material/Modal";
import styled from "styled-components";
import { format } from "timeago.js";
import { useDispatch, useSelector } from "react-redux";
import { MdEdit } from "react-icons/md";
import { RiDeleteBin5Fill } from "react-icons/ri";

import ArrowTooltip from "./ArrowTooltip";
import Avatar from "./Avatar";
import ChannelTextArea from "./ChannelTextArea";
import InvisibleSubmitButton from "./InvisibleSubmitButton";
import { useActiveChannel } from "../../hooks";
import { baseIcon, interactiveColor } from "../../design/mixins";
import { deleteMessage, editMessage } from "../../reducers/chatReducer";

const MessageButtons = styled.div`
  background-color: var(--background-primary);
  border-radius: 4px;
  border: 1px solid var(--background-secondary);
  transition: 0.1s ease-in-out;
  height: 32px;
  width: 64px;
  position: absolute;
  top: -16px;
  right: 16px;
  display: flex;
  align-items: center;
  justify-content: center;
  display: none;

  &:hover {
    box-shadow: 0 0 0 1px rgba(4, 4, 5, 0.15);
  }
`;

const Container = styled.div`
  display: flex;
  margin: 8px 0;
  padding: 8px 16px 12px 0;
  position: relative;

  &:hover {
    background-color: #32353a;

    ${MessageButtons} {
      display: flex;
    }
  }
`;

const AvatarWrapper = styled.div`
  margin: 0 16px;

  &:hover {
    cursor: pointer;
  }
`;

const Header = styled.div`
  display: flex;
  align-items: center;
  padding-bottom: 4px;
`;

const Username = styled.a`
  color: var(--header-primary);
  font-size: 14px;
  font-weight: 500;
  margin-right: 8px;

  &:hover {
    text-decoration: underline;
    cursor: pointer;
  }
`;

const Timestamp = styled.div`
  color: var(--text-muted);
  font-size: 12px;
  cursor: default;
`;

const Content = styled.div`
  color: var(--text-normal);
  font-size: 14px;
`;

const IconWrapper = styled.button`
  ${baseIcon};
  ${interactiveColor};
  background-color: transparent;

  &:hover {
    background-color: var(--background-modifier-hover);
  }
`;

const Operation = styled.span`
  font-size: 12px;
  color: var(--text-normal);

  button {
    background: transparent;
    color: var(--text-link);
    border: none;
    font-size: 12px;

    &:hover {
      text-decoration: underline;
    }
  }
`;

const PopupContainer = styled.div`
  background-color: var(--background-primary);
  color: var(--text-normal);
  top: 50%;
  left: 50%;
  position: absolute;
  transform: translateX(-50%) translateY(-50%);
  width: 440px;
  border-radius: 4px;
  font-size: 15px;
`;

const PopupMessageContainer = styled.div`
  padding: 16px;

  h2 {
    padding-bottom: 16px;
  }
`;

const PopupButtonContainer = styled.div`
  background-color: var(--background-secondary);
  border-radius: 4px;
  text-align: right;
  padding: 12px 16px;
`;

const CancelButton = styled.button`
  color: white;
  padding: 10px 24px;
  margin: 0 8px;
  background: transparent;
  border: none;

  &:hover {
    text-decoration: underline;
  }
`;

const DeleteButton = styled.button`
  color: white;
  padding: 10px 24px;
  border-radius: 4px;
  border: none;
  background-color: #f04444;

  &:hover {
    background-color: #c83434;
  }
`;

const IconButton = ({ children, ...delegated }) => {
  return (
    <IconWrapper as="button" type="button" size="20px" w="32px" {...delegated}>
      {children}
    </IconWrapper>
  );
};

const Message = ({ message, handleClick }) => {
  const user = useSelector((state) => state.session.user);
  const [showTextArea, setShowTextArea] = useState(false);
  const dispatch = useDispatch();
  const activeChannel = useActiveChannel();
  const [openDeleteMessage, setOpenPopup] = useState(false);

  const handleSubmit = (event) => {
    event.preventDefault();
    const content = event.target.value;
    console.log(content);
    dispatch(
      editMessage({
        id: message.id,
        channelId: activeChannel.id,
        content,
        user,
      })
    );
  };

  const handleDeleteButtonClick = () => {
    dispatch(deleteMessage({ id: message.id, channelId: activeChannel.id }));
  };

  useEffect(() => {
    if (!showTextArea) {
      return;
    }

    const onKeyDown = (event) => {
      const enterKey = 13;
      const escapeKey = 27;
      if (event.keyCode === enterKey) {
        handleSubmit(event);
        setShowTextArea(false);
      } else if (event.keyCode === escapeKey) {
        event.preventDefault();
        setShowTextArea(false);
      }
    };

    document.addEventListener("keydown", onKeyDown);
    return () => document.removeEventListener("keydown", onKeyDown);
  });

  const handleOpenPopup = () => setOpenPopup(true);
  const handleClosePopup = () => setOpenPopup(false);

  return (
    <Container>
      <AvatarWrapper onClick={handleClick}>
        <Avatar size="27px" w="40px" bgColor={message.user.avatarColor} />
      </AvatarWrapper>
      <div style={{ width: "100%" }}>
        <Header>
          <Username onClick={handleClick}>{message.user.username}</Username>
          <Timestamp>
            {format(message.createdAt)}
            {message.updatedAt ? " (edited)" : ""}
          </Timestamp>
        </Header>
        {showTextArea ? (
          <>
            <form onSubmit={handleSubmit}>
              <ChannelTextArea
                type="text"
                name="content"
                defaultValue={message.content}
              />
              <Operation>
                escape to{" "}
                <button onClick={() => setShowTextArea(false)}>cancel</button> •
                enter to <button>save</button>
              </Operation>
              <InvisibleSubmitButton />
            </form>
          </>
        ) : (
          <Content>{message.content}</Content>
        )}
      </div>

      {user.id === message.user.id && (
        <>
          <MessageButtons>
            <ArrowTooltip title="Edit" placement="top">
              <IconButton onClick={() => setShowTextArea(true)}>
                <MdEdit />
              </IconButton>
            </ArrowTooltip>
            <ArrowTooltip title="Delete" placement="top">
              <IconButton onClick={handleOpenPopup}>
                <RiDeleteBin5Fill />
              </IconButton>
            </ArrowTooltip>
          </MessageButtons>

          <Modal open={openDeleteMessage} onClose={handleClosePopup}>
            <PopupContainer className="disable-select">
              <PopupMessageContainer>
                <h2>Delete Message</h2>
                Are you sure you want to delete this message?
              </PopupMessageContainer>
              <PopupButtonContainer>
                <CancelButton onClick={handleClosePopup}>Cancel</CancelButton>
                <DeleteButton onClick={handleDeleteButtonClick}>
                  Delete
                </DeleteButton>
              </PopupButtonContainer>
            </PopupContainer>
          </Modal>
        </>
      )}
    </Container>
  );
};

export default Message;
