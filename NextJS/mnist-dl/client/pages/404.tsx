import Link from "next/link";
import React from "react";

import styles from "../styles/NotFound.module.css";
const NotFound = () => {
  return (
    <div className={styles.not__found}>
      <div className={styles.not__found__main}>
        <h1>
          4<span>0</span>4
        </h1>
        <p>Page Not found</p>
      </div>
      <Link href={"/"}>GO TO HOME</Link>
    </div>
  );
};

export default NotFound;
