import React from "react";
import {
  Box,
  makeStyles,
  Typography,
} from "@material-ui/core";
import Carousel from "react-multi-carousel";
import "react-multi-carousel/lib/styles.css";


const useStyles = makeStyles({
  row_wrapper: {
    width: "99%",
    minWidth:960,
    margin: "5px 0px",
    padding: "5px 0px",
    paddingBottom:10,
    backgroundColor: "#ffffff",
  },
  row_title: {
    fontSize: 20,
    fontWeight: 600,
    margin:"10px 0px 10px 20px",
  },
  products_wrapper: {
    margin: "5px 10px",
    padding: 5,
    backgroundColor: "#ffffff",
  },
});

function FeaturedBrandsRow({ brandsUrls }) {
  const classes = useStyles();
  const responsive = {
    superLargeDesktop: {
      // the naming can be any, depends on you.
      breakpoint: { max: 4000, min: 3000 },
      items: 5,

    },
    desktop: {
      breakpoint: { max: 3000, min: 1024 },
      items: 4,
    },
    tablet: {
      breakpoint: { max: 1024, min: 464 },
      items: 3,
    },
    mobile: {
      breakpoint: { max: 464, min: 0 },
      items: 1,
    },
  };
  return (
    <Box className={classes.row_wrapper} boxShadow={1}>
      <Box>
        <Typography className={classes.row_title}>Featured Brands </Typography>
      </Box>
      <Box className={classes.products_wrapper} textAlign="center">
        <Carousel
          swipeable={true}
          draggable={false}
          showDots={false}
          responsive={responsive}
          ssr={true} 
          infinite={true}
          autoPlay={true}
          autoPlaySpeed={2500}
          keyBoardControl={true}
          customTransition="all 200ms"
          transitionDuration={500}
          containerClass="carousel-container"
          removeArrowOnDeviceType={["mobile"]}
          dotListClass="custom-dot-list-style"
          itemClass="carousel-item-padding-40-px"
        >
          {brandsUrls?.map((url, index) => (
            <Box key={index}>
              <img src={url} alt="Featured Brands" style={{ width: "100%", padding:"0px 5px", cursor:"pointer", }} />
            </Box>
          ))}
        </Carousel>
      </Box>
    </Box>
  );
}

export default FeaturedBrandsRow;
