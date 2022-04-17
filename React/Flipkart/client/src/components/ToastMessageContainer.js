import React from "react";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.min.css";

function ToastMessageContainer() {
  return (
    <ToastContainer bodyStyle={{ fontSize: 16 }} style={{ width: "27%", minWidth:300  }} />
  );
}

export default ToastMessageContainer;
