import styled from "styled-components";

const Input = styled.input`
  background-color: rgba(0, 0, 0, 0.1);
  font-size: 14px;
  padding: 10px;
  margin-bottom: 12px;
  height: 40px;
  width: 100%;
  border-radius: 3px;
  border: 1px solid
    ${(p) => (p.error ? "var(--text-danger)" : "rgba(0, 0, 0, 0.3)")};
  outline: none;
  color: var(--text-normal);
  transition: border-color 0.2s ease-in-out;

  &:focus {
    outline: none;
    border: 1px solid ${(p) => (p.error ? "var(--text-danger)" : "#00B0F4")};
  }
`;

export default Input;
