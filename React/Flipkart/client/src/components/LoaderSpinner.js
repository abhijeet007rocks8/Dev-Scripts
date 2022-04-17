import React from "react";
import { Box, CircularProgress, makeStyles } from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
  center: {
    marginTop: "50vh",
    width: "100%",
    height: "100%",
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
  },
}));
function LoaderSpinner() {
  const classes = useStyles();
  return (
    <Box className={classes.center}>
        <CircularProgress style={{ color: "#2874f0" }} />
    </Box>
  );
}

export default LoaderSpinner;
