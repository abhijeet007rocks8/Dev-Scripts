import { makeStyles, Typography, Box, Button } from "@material-ui/core";
import { useSelector } from "react-redux";

import { emptyCartUrl } from "../../constants/data";

const useStyle = makeStyles((theme) => ({
  component: {
    width: "80%",
    minWidth: 500,
    height: "65vh",
    background: "#fff",
    margin: "80px 140px",
    [theme.breakpoints.down("md")]: {
      margin: "80px 0px",
    },
  },
  image: {
    width: "20%",
    minWidth: 150,
  },
  container: {
    textAlign: "center",
    paddingTop: 70,
  },
  btn: {
    display: "block",
    margin: "0 auto",
    marginTop: 15,
    padding: "5px 60px",
  },
}));

const EmptyCart = () => {
  const classes = useStyle();
  const { isAuthenticate } = useSelector((state) => state.userReducer);

  return (
    <Box className={classes.component}>
      <Box className={classes.container}>
        <img src={emptyCartUrl} className={classes.image} />
        {isAuthenticate ? (
          <>
            <Typography>Your cart is empty!</Typography>
            <span>Add items to it now.</span>
            <Button
              variant="contained"
              className={classes.btn}
              color="primary"
              onClick={() => window.location.replace("/")}
              style={{ background: "#2874f0", textTransform: "capitalize" }}
            >
              {" "}
              Shop Now
            </Button>
          </>
        ) : (
          <>
            <Typography>Missing Cart items?</Typography>
            <span>Login to see the items you added previously</span>
            <br />
            <Button
              variant="contained"
              className={classes.btn}
              color="primary"
              onClick={() => window.location.replace("/login")}
              style={{ background: "#fb641b", textTransform: "capitalize" }}
            >
              Login
            </Button>
          </>
        )}
      </Box>
    </Box>
  );
};

export default EmptyCart;
