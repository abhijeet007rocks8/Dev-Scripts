import React from "react";
import { Box, makeStyles } from "@material-ui/core";
import Carousel from "react-material-ui-carousel";
import { bannerData, horizontalPosterLink } from "../../constants/data";

const useStyle = makeStyles({
  banner: {
    margin: "20px 10px 0px 10px",
    minWidth:960,
  },
  banner_img: {
    width: "100%",
    height: 280,
    cursor: "pointer",
  },
});
function HomeBanner() {
  const classes = useStyle();
  return (
    <Box boxShadow={1} className={classes.banner}>
      <Carousel
        animation="slide"
        interval={3000}
        navButtonsAlwaysVisible={true}
        indicators={false}
        navButtonsProps={{
          style: {
            backgroundColor: "#ffffff",
            borderRadius: 0,
            color: "#212121",
            margin: 0,
            height: 47,
          },
        }}
      >
        {bannerData.map((url, i) => (
          <img src={url} className={classes.banner_img} alt="Offers" key={i} />
        ))}
      </Carousel>
      <img
        src={horizontalPosterLink}
        alt="Discount"
        style={{ width: "100%", cursor: "pointer" }}
      />
    </Box>
  );
}

export default HomeBanner;
