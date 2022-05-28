import React from "react";

import styled from "styled-components";
import { FaHashtag } from "react-icons/fa";

import { baseIcon, roundedBackground } from "../../design/mixins";

export const Wrapper = styled.div`
  ${baseIcon};
  color: ${(p) => p.color || "var(--text-muted)"};
  ${(p) => p.bgColor && roundedBackground};
`;

const Hashtag = ({ ...delegated }) => {
  return (
    <Wrapper {...delegated}>
      <FaHashtag />
    </Wrapper>
  );
};

export default Hashtag;
