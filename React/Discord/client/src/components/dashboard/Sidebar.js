import React from "react";

import styled from "styled-components";

import ServerList from "./ServerList";
import ChannelList from "./ChannelList";

const Container = styled.div`
  display: flex;
  flex: 0 0 auto;
  height: 100vh;
`;

const Sidebar = () => {
  return (
    <Container>
      <ServerList />
      <ChannelList />
    </Container>
  );
};

export default Sidebar;
