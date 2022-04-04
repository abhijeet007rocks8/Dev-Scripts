import React from "react";
import Head from "../Head/Head";
import styles from "./Layout.module.css";

const Layout: React.FC = ({ children }) => {
  return (
    <div className={styles.layout__layout}>
      <Head />
      <div className={styles.layout__container}>{children}</div>
    </div>
  );
};
export default Layout;
