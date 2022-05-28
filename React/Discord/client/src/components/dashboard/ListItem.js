import React from "react";

import styled, { css } from "styled-components";

const Text = styled.span`
  font-size: 15px;
  font-weight: 500;
  color: var(--channels-default);
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
`;

const Container = styled.div`
  display: flex;
  align-items: center;
  border-radius: 4px;

  &:hover {
    background-color: var(--background-modifier-hover);
    cursor: pointer;
  }

  &:hover > ${Text} {
    color: var(--interactive-hover);
  }

  ${(p) =>
    p.isActive &&
    css`
      &,
      &:hover {
        background-color: var(--background-modifier-selected);
      }

      & > ${Text}, &:hover > ${Text} {
        color: var(--interactive-active);
      }
    `}
`;

const ListItem = ({ icon, text, isActive, ...delegated }) => {
  return (
    <Container isActive={isActive} {...delegated}>
      <>{icon}</>
      {text && (
        <Text isActive={isActive} className="disable-select">
          {text}
        </Text>
      )}
    </Container>
  );
};

export default ListItem;
