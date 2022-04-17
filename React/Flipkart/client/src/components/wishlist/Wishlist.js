import React, { useEffect, useState } from "react";
import { Box, Typography } from "@material-ui/core";
import { useDispatch, useSelector } from "react-redux";

import { makeStyles } from "@material-ui/styles";

import { getWishlistItems } from "../../actions/wishlistActions";
import { emptyWishlist } from "../../constants/data";

import WishlistItem from "./WishlistItem";
import LoaderSpinner from "../LoaderSpinner";

const useStyles = makeStyles({
  container: {},
  header: {
    padding: "20px 40px",
    fontSize: 18,
    fontWeight: 500,
    borderBottom: "1px solid #e0e0e0",
  },
  emptyContainer: {
    height:500,
    display:"flex",
    flexDirection:"column",
    justifyContent:"center",
    alignItems:"center",
    textAlign: "center",
  },
  heading: {
    fontWeight: 600,
    fontSize: 18,
    marginTop: 35,
    marginBottom: 10,
  },
  para: {
    fontSize: 14,
  },
});

function Wishlist() {
  const { wishlistItems } = useSelector((state) => state.wishlistReducer);
  const { isAuthenticate } = useSelector((state) => state.userReducer);

  const [isLoading, setIsLoading] = useState(true);

  const dispatch = useDispatch();
  const classes = useStyles();

  useEffect(() => {
    if (isAuthenticate) {
      dispatch(getWishlistItems());
      setTimeout(() => {
        setIsLoading(false);
      }, 600);
    }
  }, []);

  return isLoading ? (
    <LoaderSpinner />
  ) : (
    <Box className={classes.container}>
      {wishlistItems.length > 0 ? (
        <>
          <Typography className={classes.header}>
            My Wishlist ({wishlistItems.length})
          </Typography>
          {wishlistItems.map((item) => (
            <WishlistItem item={item} />
          ))}
        </>
      ) : (
        <Box className={classes.emptyContainer}>
          <img src={emptyWishlist} alt="Empty" />
          <Typography className={classes.heading}>Empty Wishlist</Typography>
          <Typography className={classes.para}>
            You have no items in your wishlist. Start adding!
          </Typography>
        </Box>
      )}
    </Box>
  );
}

export default Wishlist;
