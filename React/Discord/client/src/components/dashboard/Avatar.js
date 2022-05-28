import React from "react";

import styled from "styled-components";
import { FaDiscord } from "react-icons/fa";
import { MdFiberManualRecord } from "react-icons/md";

import { baseIcon, roundedBackground } from "../../design/mixins";

const Wrapper = styled.div`
  ${baseIcon};
  ${roundedBackground};
`;

export const GreenDotWrapper = styled(Wrapper)`
  padding: 0.5px;
  height: 16px;
  width: 16px;
  position: absolute;
  right: -4px;
  bottom: -4px;
`;

const Container = styled.div`
  position: relative;
`;

const GreenDot = () => {
  return (
    <GreenDotWrapper color="#3aa55d" bgColor="var(--background-secondary-alt)">
      <MdFiberManualRecord />
    </GreenDotWrapper>
  );
};

const DiscordIcon = ({ ...delegated }) => {
  return (
    <Wrapper color="white" {...delegated}>
      <FaDiscord />
    </Wrapper>
  );
};

const Avatar = ({ status, onClick, ...delegated }) => {
  return status ? (
    <Container onClick={onClick}>
      <DiscordIcon {...delegated} />
      <GreenDot />
    </Container>
  ) : (
    <DiscordIcon onClick={onClick} {...delegated} />
  );
};

export default Avatar;
