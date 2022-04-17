import React, { useState, useEffect } from "react";
import { Box, makeStyles, Typography } from "@material-ui/core";
import { useDispatch, useSelector } from "react-redux";
import clsx from "clsx";


import { setTotalAmount } from "../../actions/orderActions";

const useStyle = makeStyles({
  header: {
    padding: "15px 24px",
    background: "#fff",
  },
  greyTextColor: {
    color: "#878787",
  },
  container: {
    "& > *": {
      marginBottom: 20,
      fontSize: 14,
    },
  },
  price: {
    float: "right",
  },
  totalAmount: {
    fontSize: 18,
    fontWeight: 600,
    borderTop: "1px dashed #e0e0e0",
    padding: "20px 0",
    borderBottom: "1px dashed #e0e0e0",
  },
});

const TotalView = ({ page = "cart" }) => {
  const classes = useStyle();
  const [price, setPrice] = useState(0);
  const [discount, setDiscount] = useState(0);
  const [deliveryCharges, setDeliveryCharges] = useState(0);
  const { cartItems, stateChangeNotifyCounter } = useSelector(
    (state) => state.cartReducer
  );
  const dispatch = useDispatch();

  useEffect(() => {
    totalAmount();
  }, [cartItems, stateChangeNotifyCounter]);

  const totalAmount = () => {
    let price = 0,
      discount = 0;
    cartItems.map((item) => {
      price += item.price.mrp * item.qty;
      discount += (item.price.mrp - item.price.cost) * item.qty;
    });

    setPrice(price);
    setDiscount(discount);
    setDeliveryCharges(price - discount > 500 ? 0 : 40);

    if (page === "checkout") {
      dispatch(setTotalAmount(price - discount + deliveryCharges));
    }
  };

  return (
    <Box>
      <Box
        className={classes.header}
        style={{ borderBottom: "1px solid #f0f0f0" }}
      >
        <Typography className={classes.greyTextColor}>PRICE DETAILS</Typography>
      </Box>
      <Box className={clsx(classes.header, classes.container)}>
        <Typography>
          Price ({cartItems?.length} item)
          <span className={classes.price}>₹{price}</span>
        </Typography>
        {page === "cart" && (
          <Typography>
            Discount<span className={classes.price}>-₹{discount}</span>
          </Typography>
        )}
        <Typography>
          Delivery Charges
          <span className={classes.price}>
            {deliveryCharges > 0 ? "₹40" : "FREE"}{" "}
          </span>
        </Typography>
        <Typography className={classes.totalAmount}>
          {page === "checkout" ? "Total Payable" : "Total Amount"}
          <span className={classes.price}>
            ₹{price - discount + deliveryCharges}
          </span>
        </Typography>
        <Typography style={{ fontSize: 16, color: "green" }}>
          You will save ₹{discount - deliveryCharges} on this order
        </Typography>
      </Box>
    </Box>
  );
};

export default TotalView;
