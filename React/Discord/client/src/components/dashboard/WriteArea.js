import React from "react";

import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";

import InvisibleSubmitButton from "./InvisibleSubmitButton";
import ChannelTextArea from "./ChannelTextArea";
import { sendMessage, typing, stopTyping } from "../../reducers/chatReducer";
import { useActiveChannel } from "../../hooks";

const Container = styled.div`
  background-color: var(--background-primary);
  height: 68px;
  padding: 0 16px;
  flex: 0 0 auto;
`;

const Form = styled.form``;

const TypingStatus = styled.span`
  font-size: 12px;
  font-weight: 500;
  color: var(--text-normal);
`;

const WriteArea = () => {
  const dispatch = useDispatch();
  const user = useSelector((state) => state.session.user);

  const activeChannel = useActiveChannel();

  let timeout = undefined;
  const handleSubmit = (event) => {
    event.preventDefault();
    const content = event.target.content.value;
    if (content !== "") {
      dispatch(sendMessage({ user, content, channelId: activeChannel.id }));
      event.target.reset();
    }
  };

  const typingUser = useSelector((state) => state.chat.typingUser);

  // Detect whether the user is typing
  const handleKeyUp = (event) => {
    const enterKey = 13;
    if (event.keyCode === enterKey) {
      dispatch(stopTyping(user));
    } else {
      dispatch(typing(user));
      clearTimeout(timeout);
      timeout = setTimeout(() => dispatch(stopTyping(user)), 2000);
    }
  };

  return (
    <Container>
      <Form onSubmit={handleSubmit}>
        <ChannelTextArea
          type="text"
          name="content"
          placeholder={`Message #${activeChannel?.name}`}
          onKeyUp={handleKeyUp}
        />
        <InvisibleSubmitButton />
      </Form>
      <TypingStatus>
        {typingUser && `${typingUser.username} is typing...`}
      </TypingStatus>
    </Container>
  );
};

export default WriteArea;
