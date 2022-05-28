import React from "react";

import { useDispatch, useSelector } from "react-redux";
import { FaBars, FaGithub, FaSignOutAlt, FaUserFriends } from "react-icons/fa";
import styled from "styled-components";

import ArrowTooltip from "./ArrowTooltip";
import Hashtag from "./Hashtag";
import List from "./List";
import { toggleSidebar } from "../../reducers/sidebarReducer";
import { toggleMemberList } from "../../reducers/memberListReducer";
import { logout } from "../../reducers/sessionReducer";
import { baseIcon, interactiveColor, hideInDesktop } from "../../design/mixins";

const Container = styled.div`
  background-color: var(--background-primary);
  border-bottom: 1px solid var(--background-tertiary);
  height: 48px;
  flex: 0 0 auto;
  padding: 0 16px;
  align-items: center;
  display: flex;
  justify-content: space-between;
`;

const Heading = styled.h2`
  font-size: 16px;
  font-weight: 600;
  color: var(--header-primary);
`;

const IconWrapper = styled.button`
  ${baseIcon};
  ${interactiveColor};
  background-color: transparent;

  ${(p) => p.$isHamburger && hideInDesktop}
`;

const IconButton = ({ children, href, ...delegated }) => {
  const tag = href ? "a" : "button";
  const type = tag === "button" ? "button" : undefined;

  return (
    <IconWrapper
      as={tag}
      type={type}
      href={href}
      size="22px"
      w="24px"
      {...delegated}
    >
      {children}
    </IconWrapper>
  );
};

const Header = () => {
  const dispatch = useDispatch();
  const isMemberListOpen = useSelector((state) => state.memberList.isOpen);
  const channels = useSelector((state) => state.channels);
  const activeChannelName =
    !channels.loading && channels.byId[channels.active]?.name;

  return (
    <Container id="header" className="disable-select">
      <List horizontal={true} gap="10px">
        <IconButton onClick={() => dispatch(toggleSidebar())} $isHamburger>
          <FaBars />
        </IconButton>
        <List horizontal={true} gap="6px" style={{ alignItems: "center" }}>
          <Hashtag size="22px" w="24px" />
          <Heading>{!channels.loading && activeChannelName}</Heading>
        </List>
      </List>
      <List horizontal={true} gap="16px">
        <ArrowTooltip title="GitHub Repo">
          <IconButton
            href=""
            target="blank"
          >
            <FaGithub />
          </IconButton>
        </ArrowTooltip>
        <ArrowTooltip
          title={`${isMemberListOpen ? "Hide" : "Show"} Member list`}
        >
          <IconButton
            onClick={() => dispatch(toggleMemberList())}
            isActive={isMemberListOpen}
          >
            <FaUserFriends />
          </IconButton>
        </ArrowTooltip>
        <ArrowTooltip title="Logout">
          <IconButton onClick={() => dispatch(logout())}>
            <FaSignOutAlt />
          </IconButton>
        </ArrowTooltip>
      </List>
    </Container>
  );
};

export default Header;
