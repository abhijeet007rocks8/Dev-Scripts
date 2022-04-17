import React from "react";
import { Button } from "@material-ui/core";
import { Link } from "react-router-dom";

function ErrorPage() {
  return (
    <div
      style={{
        textAlign: "center",
        fontSize: "14px",
        padding: "20px",
        marginTop: "100px",
      }}
    >
      <div>
        <img
          style={{ width: "450px", maxWidth: "100%" }}
          src="https://img1a.flixcart.com/www/linchpin/fk-cp-zion/img/error-500_f9bbb4.png"
          alt=""
        />
        <div
          style={{
            fontSize: "1.3em",
            paddingTop: "10px",
            marginBottom: "35px",
          }}
        >
          Unfortunately the page you are looking for has been moved or deleted
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

export default ErrorPage;
