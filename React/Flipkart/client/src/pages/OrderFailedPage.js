import React, { useEffect } from "react";
import { Button } from "@material-ui/core";
import { Link, useHistory } from "react-router-dom";

function OrderFailedPage() {
  useEffect(() => {
    setTimeout(() => {
      history.replace("/");
    }, 30000);
  }, []);

  const history = useHistory();

  return (
      <div
        style={{
          textAlign: "center",
          fontSize: "14px",
          padding: "20px",
          marginTop: "100px",
          fontWeight: 500,
          marginBottom:"6%",
        }}
      >
        <div>
          <img
            style={{ width: "450px", maxWidth: "100%" }}
            src="try_again.png"
            alt=""
          />
          <div
            style={{
              fontSize: "1.3em",
              marginBottom: "35px",
            }}
          >
            Unfortunately the order was failed ! Please try again later
          </div>
          <Button
            style={{ backgroundColor: "#2874f0" }}
            variant="contained"
            color="primary"
          >
            <Link to="/">GO TO HOMEPAGE</Link>
          </Button>
        </div>
      </div>
  );
}

export default OrderFailedPage;
