import { createContext } from "react";
import { createTheme, ThemeProvider } from "@material-ui/core/styles";

const TemplateContext = createContext();

const TemplateProvider = ({ children }) => {
  const theme = createTheme({
    overrides: {
      MuiDialog:{
        paperWidthSm:{
          maxWidth:"800px",
          width:"50%",
          overflowY:"auto",
        }
      },
      MuiDialogContent: {
        root: {
          padding: 0,
          '&:first-child':{
            paddingTop:0,
          }
        },
      },
    },
  });
  return (
    <TemplateContext.Provider>
      <ThemeProvider theme={theme}>{children}</ThemeProvider>
    </TemplateContext.Provider>
  );
};

export default TemplateProvider;
