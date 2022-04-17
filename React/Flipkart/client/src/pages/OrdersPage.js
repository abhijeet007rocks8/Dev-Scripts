import React, { useState } from "react";
import { Box, makeStyles, Typography, Button, Grid } from "@material-ui/core";
import { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

import { getOrderDetails } from "../actions/orderActions";

import OrderRow from "../components/product/OrderRow";
import LoaderSpinner from "../components/LoaderSpinner";

import { noOrdersUrl } from "../constants/data";
import { useHistory } from "react-router-dom";

const useStyle = makeStyles((theme) => ({
  component: {
    marginTop: 55,
    padding: "30px 135px",
    display: "flex",
    [theme.breakpoints.down("sm")]: {
      padding: "15px 0",
    },
    [theme.breakpoints.down("md")]: {
      marginBottom: 20,
    },
  },
  leftComponent: {
    paddingRight: 15,
    [theme.breakpoints.down("sm")]: {
      marginBottom: 15,
    },
  },
  header: {
    padding: "15px 24px",
    margin: "10px 0px",
    background: "#fff",
  },
  itemRow: {
    padding: "16px 22px",
    background: "#fff",
    boxShadow: "0 -2px 10px 0 rgb(0 0 0 / 10%)",
    borderTop: "1px solid #f0f0f0",
    [theme.breakpoints.down("md")]: {
      padding:"15px 0px"
    },
  },
  emptyComponent: {
    height:"90vh",
    display:"flex",
    justifyContent:"center",
    alignItems:"center",
    flexDirection:"column",
    textAlign: "center",
  },
  btn: {
    display: "block",
    margin: "0 auto",
    marginTop: 15,
    fontSize:16,
    padding: "5px 30px",
  },
  image: {
    width: "20%",
    minWidth:200,
    objectFit:"contain"
  },
}));

function OrdersPage() {
  const classes = useStyle();
  const { isAuthenticate } = useSelector((state) => state.userReducer);
  const [isLoading, setIsLoading] = useState(true);
  const { orderDetails } = useSelector((state) => state.orderReducer);
  const dispatch = useDispatch();
  const history = useHistory();

  useEffect(() => {
    if (!isAuthenticate) {
      history.replace("/login?ref=orders");
    }
    dispatch(getOrderDetails());
    setTimeout(() => {
      setIsLoading(false);
    }, 700);
  }, [isAuthenticate]);


  return isLoading ? (
    <LoaderSpinner />
  ) : (
    <>
      {orderDetails?.length > 0 ? (
        <Grid container className={classes.component}>
          {/* <Grid item lg={1} md={1} sm={12} xs={12}>
        </Grid> */}
          <Grid
            item
            lg={12}
            md={12}
            sm={12}
            xs={12}
            className={classes.leftComponent}
          >
            <Box className={classes.header}>
              <Typography style={{ fontWeight: 600, fontSize: 22 }}>
                My Orders
              </Typography>
            </Box>
            {orderDetails?.map((order) => (
              <OrderRow order={order} />
            ))}
          </Grid>
        </Grid>
      ) : (
        <Box className={classes.emptyComponent}>
          <img src={noOrdersUrl} className={classes.image} />
          <Typography style={{ fontSize: 22, fontWeight: 600 }}>
            You have no orders
          </Typography>
          <Button
            variant="contained"
            className={classes.btn}
            color="primary"
            onClick={() => window.location.replace("/")}
            style={{ background: "#2874f0", textTransform: "capitalize" }}
          >
            {" "}
            Start Shopping
          </Button>
        </Box>
      )}
    </>
  );
}

export default OrdersPage;
