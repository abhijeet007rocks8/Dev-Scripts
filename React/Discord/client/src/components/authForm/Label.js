import styled from "styled-components";

const Label = styled.label`
  color: ${(p) => (p.error ? "var(--text-danger)" : "var(--header-secondary)")};
  font-weight: 500;
  text-transform: uppercase;
  padding: 8px 0;
`;

export default Label;
