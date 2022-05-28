import React from "react";

import { useSelector } from "react-redux";
import styled from "styled-components";

import Avatar from "./Avatar";
import List from "./List";
import ListItem from "./ListItem";
import UserPopover from "./UserPopover";
import { usePopover } from "../../hooks";

const Container = styled.div`
  background-color: var(--background-secondary);
  width: 240px;
  flex: 0 0 auto;
  height: calc(100vh - 48px);
  overflow: hidden scroll;
  text-overflow: ellipsis;
  padding: 10px 2px 10px 12px;

  @media (max-width: 768px) {
    height: 100vh;
  }
`;

const Heading = styled.h3`
  font-size: 13px;
  font-weight: 500;
  margin: 8px 8px 4px 8px;
  color: var(--channels-default);
  text-transform: uppercase;
`;

const MemberList = ({ isMobile }) => {
  const users = useSelector((state) => state.memberList.onlineUsers);
  const [
    user,
    anchorEl,
    showPopover,
    setShowPopover,
    handleClick,
    handleClickAway,
  ] = usePopover();

  return (
    <Container>
      <Heading className="disable-select">online — {users.length}</Heading>
      <List gap="2px">
        {users.map((user) => (
          <ListItem
            key={user.id}
            icon={
              <Avatar
                size="21px"
                w="32px"
                bgColor={user.avatarColor}
                status="online"
              />
            }
            text={user.username}
            style={{ gap: "12px", padding: "6px 8px" }}
            onClick={(event) => handleClick(event, user)}
          />
        ))}
      </List>
      <UserPopover
        open={showPopover}
        anchorEl={anchorEl}
        onClose={handleClickAway}
        anchorOrigin={{ vertical: "center", horizontal: "left" }}
        transformOrigin={{ vertical: "top", horizontal: "right" }}
        user={user}
        setShowPopover={setShowPopover}
      />
    </Container>
  );
};

export default MemberList;
