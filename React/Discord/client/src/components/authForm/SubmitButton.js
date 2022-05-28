import styled from "styled-components";

const SubmitButton = styled.button.attrs(() => ({ type: "submit" }))`
  background-color: rgb(88, 101, 242);
  border: 0;
  border-radius: 4px;
  padding: 12px 8px;
  margin: 16px 0 12px 0;
  color: white;
  font-size: 14px;
  font-weight: 500;
  font-family: inherit;

  &:hover {
    background-color: rgb(71, 82, 196);
    cursor: pointer;
  }
`;

export default SubmitButton;
