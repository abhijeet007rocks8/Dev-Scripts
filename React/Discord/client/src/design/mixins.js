import { css } from "styled-components";

export const wh = ({ w, h = w }) => css`
  width: ${w};
  height: ${h};
`;

export const font = ({ color, size }) => css`
  color: ${color || "var(--text-normal)"};
  font-size: ${size || "1rem"};
`;

export const baseIcon = ({ border }) => css`
  display: flex;
  justify-content: center;
  align-items: center;
  border: ${border || "none"};
  ${wh};
  ${font};
`;

export const roundedBackground = ({ bgColor, bgColorOnHover }) => css`
  border-radius: 50%;
  background-color: ${bgColor};

  ${bgColorOnHover &&
  css`
    transition: 0.3s;

    &:hover {
      background-color: bgColorOnHover;
      border-radius: 16px;
    }

    ${(p) =>
      p.isActive &&
      css`
        border-radius: 16px;
      `}
  `}
`;

export const interactiveColor = ({ isActive }) => css`
  color: ${isActive ? "var(--interactive-active)" : "var(--channels-default)"};

  &:hover {
    color: var(--interactive-hover);
  }
`;

export const hideInDesktop = css`
  display: none;

  @media (max-width: 768px) {
    display: block;
  }
`;
