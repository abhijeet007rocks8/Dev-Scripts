import React from "react";

import styled from "styled-components";

const Wrapper = styled.div`
  display: flex;
  flex-direction: ${(p) => (p.horizontal ? "row" : "column")};
  gap: ${(p) => p.gap};
`;

const List = ({ horizontal, gap, children, ...delegated }) => {
  return (
    <Wrapper horizontal={horizontal} gap={gap} {...delegated}>
      {children}
    </Wrapper>
  );
};

export default List;
