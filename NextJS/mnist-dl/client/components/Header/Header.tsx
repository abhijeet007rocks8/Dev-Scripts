import React from "react";

import styles from "./Header.module.css";
const Header = () => {
  return (
    <div className={styles.header}>
      <div className={styles.header__left}>
        <h1>Hand Written Digits</h1>
      </div>
      <div className={styles.header__right}>
        <h1>Home</h1>
      </div>
    </div>
  );
};

export default Header;
