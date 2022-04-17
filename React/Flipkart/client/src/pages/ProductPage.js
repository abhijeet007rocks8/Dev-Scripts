import React, { useEffect, useState } from "react";
import { Box, Typography, makeStyles, Grid } from "@material-ui/core";
import StarIcon from "@material-ui/icons/Star";
import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router";

import { getProductById } from "../actions/productActions";
import { fassured } from "../constants/data";

import ProductDetail from "../components/product/ProductDetail";
import ProductImageSlider from "../components/product/ProductImageSlider";
import LoaderSpinner from "../components/LoaderSpinner";
import ToastMessageContainer from "../components/ToastMessageContainer";

const useStyles = makeStyles((theme) => ({
  component: {
    marginTop: 55,
    background: "#F2F2F2",
    padding: "10px 3%",
  },
  container: {
    background: "#FFFFFF",
    display: "flex",
    [theme.breakpoints.down("md")]: {
      margin: 0,
      padding:"0 7px",
    },
  },
  rightContainer: {
    marginTop: 15,
    "& > *": {
      marginTop: 10,
    },
  },
  price: {
    fontSize: 28,
  },
  smallText: {
    fontSize: 14,
  },
  greyTextColor: {
    color: "#878787",
    fontSize: 16,
    marginLeft: 5,
  },
  rate: {
    display: "flex",
    alignItems: "center",
    color: "#fff",
    padding: "2px 5px",
    borderRadius: 5,
    fontWeight: 600,
    fontSize: 12,
    backgroundColor: "#388e3c",
  },
}));

function ProductPage() {
  const classes = useStyles();
  const [isLoading, setIsLoading] = useState(true);

  const { product } = useSelector((state) => state.productReducer);
  const { id } = useParams();
  const dispatch = useDispatch();
  var rate = (Math.random() * 5).toFixed(1);
  var reviewCount = Math.round(Math.random() * 10000 + 1);
  if (rate < 4) {
    rate = 4.1;
  }
  window.scrollTo(0, 0);

  useEffect(() => {
    if (product && id !== product.id) {
      dispatch(getProductById(id));
    }
  }, [dispatch]);

  useEffect(() => {
    if (Object.keys(product).length > 0) {
      setTimeout(() => {
        setIsLoading(false);
      }, 400);
    }
  }, [product]);

  return isLoading ? (
    <LoaderSpinner />
  ) : (
    <Box className={classes.component}>
      {product && Object.keys(product).length && (
        <Grid container className={classes.container}>
          <Grid item lg={5} md={5} sm={9} xs={12}>
            <ProductImageSlider product={product} />
          </Grid>
          <Grid
            item
            lg={7}
            md={7}
            sm={7}
            xs={12}
            className={classes.rightContainer}
          >
            <Typography>{product.title.longTitle}</Typography>
            <Box style={{ display: "flex", alignItems: "center" }}>
              <Typography className={classes.rate}>
                {rate} <StarIcon style={{ fontSize: 12, marginLeft: 3 }} />
              </Typography>
              <Typography className={classes.greyTextColor}>
                ({reviewCount})
              </Typography>
              <span>
                <img src={fassured} style={{ height: 21, marginLeft: 10 }} />
              </span>
            </Box>
            <Typography>
              <span className={classes.price}>₹{product.price.cost}</span>
              &nbsp;&nbsp;&nbsp;
              <span className={classes.greyTextColor}>
                <strike>₹{product.price.mrp}</strike>
              </span>
              &nbsp;&nbsp;&nbsp;
              <span style={{ color: "#388E3C" }}>
                {product.price.discount} off
              </span>
            </Typography>
            <ProductDetail product={product} />
          </Grid>
        </Grid>
      )}
      <ToastMessageContainer />
    </Box>
  );
}

export default ProductPage;
