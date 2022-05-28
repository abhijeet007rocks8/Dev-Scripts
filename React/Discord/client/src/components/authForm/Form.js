import styled from "styled-components";

const Form = styled.form`
  display: flex;
  flex-direction: column;
  font-size: 13px;
  padding: 12px 0;
  width: 400px;

  @media (max-width: 550px) {
    width: 100%;
  }
`;

export default Form;
