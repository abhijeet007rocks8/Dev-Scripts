import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Box, makeStyles, Typography } from "@material-ui/core";
import DeleteIcon from "@material-ui/icons/Delete";
import StarIcon from "@material-ui/icons/Star";

import { makeShortText } from "../../utils/makeShortText";
import { fassured } from "../../constants/data";
import AlertDialogBox from "../AlertDialgBox";

const useStyle = makeStyles({
  component: {
    padding: "20px 40px",
    borderBottom: "1px solid #e0e0e0",
    borderRadius: 0,
    display: "flex",
  },
  itemWrapper: {
    display: "flex",
    alignItems: "center",
    color: "#000",
    "&:hover": {
      cursor: "pointer",
      "& $itemTitle": {
        color: "#2874f0",
      },
    },
  },
  itemTitle: {
    color: "#000",
  },
  image: {
    height: 110,
    width: 110,
    marginRight: 20,
    objectFit: "contain",
  },
  mid: {
    margin: 20,
  },
  greyTextColor: {
    color: "#878787",
    fontSize: 14,
    marginLeft: 5,
  },
  smallText: {
    fontSize: 14,
  },
  price: {
    fontSize: 22,
    fontWeight: 500,
  },
  remove: {
    opacity: "0.4",
    cursor: "pointer",
  },
  rightComponent: {
    marginLeft: "auto",
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
});
function WishlistItem({ item }) {
  const [isOpenDialog, setIsOpenDialog] = useState(false);

  const classes = useStyle();

  var rate = (Math.random() * 5).toFixed(1);
  var reviewCount = Math.round(Math.random() * 5000 + 1);
  if (rate < 2) {
    rate = 3.2;
  }

  const dialogClose = () => {
    setIsOpenDialog(false);
  };

  const dialogOpen = () => {
    setIsOpenDialog(true);
  };

  return (
    <>
      <Box className={classes.component}>
        <Link to={`/product/${item._id}`}>
          <Box className={classes.itemWrapper}>
            <img src={item.url} className={classes.image} />
            <Box className={classes.itemInfo}>
              <Typography className={classes.itemTitle}>
                {item.title.longTitle && makeShortText(item.title.longTitle)}
              </Typography>
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
              <Typography style={{ margin: "15px 0" }}>
                <span className={classes.price}>₹{item.price.cost}</span>
                &nbsp;&nbsp;&nbsp;
                <span className={classes.greyTextColor}>
                  <strike>₹{item.price.mrp}</strike>
                </span>
                &nbsp;&nbsp;&nbsp;
                <span style={{ color: "#388E3C" }}>
                  {item.price.discount} off
                </span>
              </Typography>
            </Box>
          </Box>
        </Link>
        <Box className={classes.rightComponent} onClick={dialogOpen}>
          <DeleteIcon className={classes.remove} />
        </Box>
      </Box>
      <AlertDialogBox
        isOpenDialog={isOpenDialog}
        handleClose={dialogClose}
        itemId={item._id}
        type="wishlist"
      />
    </>
  );
}

export default WishlistItem;
