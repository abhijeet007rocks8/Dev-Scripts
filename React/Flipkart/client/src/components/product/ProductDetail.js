import React from "react";
import {
  Box,
  Typography,
  makeStyles,
  Table,
  TableBody,
  TableRow,
  TableCell,
} from "@material-ui/core";
import clsx from "clsx";
import { LocalOffer as Badge } from "@material-ui/icons";

const useStyle = makeStyles({
  rightContainer: {
    msOverflowY: "scroll",
  },

  smallText: {
    fontSize: 14,
    verticalAlign: "baseline",
    "& > *": {
      fontSize: 14,
      marginTop: 10,
    },
  },
  greyTextColor: {
    color: "#878787",
    border: "none",
  },
  badge: {
    marginRight: 10,
    color: "#239B56",
    fontSize: 15,
  },
  wrapper: {
    display: "flex",
  },
  borderNone: {
    border: "none",
  },
});

const ProductDetail = ({ product }) => {
  const classes = useStyle();
  const adURL =
    "https://rukminim1.flixcart.com/lockin/774/185/images/CCO__PP_2019-07-14.png?q=50";
  const date = new Date(new Date().getTime() + 5 * 24 * 60 * 60 * 1000);

  return (
    <Box className={classes.rightContainer}>
      <Typography>Available offers</Typography>
      <Box className={classes.smallText}>
        <Typography>
          <Badge className={classes.badge} />
          Bank Offer 5% Unlimited Cashback on Flipkart Axis Bank Credit Card
        </Typography>
        <Typography>
          <Badge className={classes.badge} />
          Bank Offer 10% Off on Bank of Baroda Mastercard debit card first time
          transaction, Terms and Condition apply
        </Typography>
        <Typography>
          <Badge className={classes.badge} />
          Purchase this Furniture or Appliance and Get Extra ₹500 Off on Select
          ACs
        </Typography>
        <Typography>
          <Badge className={classes.badge} />
          Partner OfferExtra 10% off upto ₹500 on next furniture purchase
        </Typography>
      </Box>
      <Table>
        <TableBody>
          <TableRow className={classes.smallText}>
            <TableCell className={classes.greyTextColor}>Delivery</TableCell>
            <TableCell
              className={classes.borderNone}
              style={{ fontWeight: 600 }}
            >
              Delivery by {date.toDateString()} |{" "}
              {Number(product.price.cost) > 500 ? "Free" : "₹40"}  
            </TableCell>
          </TableRow>
          <TableRow className={classes.smallText}>
            <TableCell className={classes.greyTextColor}>Warranty</TableCell>
            <TableCell className={classes.borderNone}>No Warranty</TableCell>
          </TableRow>
          <TableRow className={classes.smallText}>
            <TableCell className={classes.greyTextColor}>Seller</TableCell>
            <TableCell className={clsx(classes.smallText, classes.borderNone)}>
              <span style={{ color: "#2874f0" }}>SuperComNet</span>
              <Typography>GST invoice available</Typography>
              <Typography>View more sellers starting from ₹329</Typography>
            </TableCell>
          </TableRow>
          <TableRow>
            <TableCell className={classes.borderNone} colSpan={2}>
              <img src={adURL} style={{ width: 390 }} />
            </TableCell>
          </TableRow>
        </TableBody>
      </Table>
    </Box>
  );
};

export default ProductDetail;
