import { Grid, makeStyles } from "@material-ui/core";
import React from "react";

const useStyle = makeStyles((theme) => ({
  component: {
    marginTop: 0,
    minWidth:960,
  },
}));

function PosterRow({ imgUrls = [] }) {
  const classes = useStyle();
  return (
    <Grid container className={classes.component}>
      {imgUrls.map((url, index) => (
        <Grid item lg={4} md={4} sm={4} xs={4} key={index}>
          <img
            src={url}
            alt="Poster"
            style={{ width: "100%", padding: 5, cursor: "pointer", }}
          />
        </Grid>
      ))}
    </Grid>
  );
}

export default PosterRow;
