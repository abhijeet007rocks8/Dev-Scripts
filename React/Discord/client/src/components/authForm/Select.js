import styled from "styled-components";

const Select = styled.select`
  margin-top: 6px;
  margin-bottom: 12px;
  padding: 10px 8px 8px 12px;
  background-color: var(--background-secondary);
  border: 1px solid var(--background-secondary-alt);
  color: var(--text-normal);
  font-size: 14px;
  border-radius: 5px;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;

  &:focus {
    outline: none;
  }

  background-image: linear-gradient(45deg, transparent 50%, gray 50%),
    linear-gradient(135deg, gray 50%, transparent 50%);
  background-position: calc(100% - 20px) calc(1em + 2px),
    calc(100% - 15px) calc(1em + 2px);
  background-size: 5px 5px, 5px 5px;
  background-repeat: no-repeat;

  &:-moz-focusring {
    color: transparent;
    text-shadow: 0 0 0 #000;
  }
`;

export default Select;
