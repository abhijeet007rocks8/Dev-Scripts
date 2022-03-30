import "../styles/globals.css";
import Layout from "../components/Layout/Layout";

const App = ({ Component, pageProps }) => {
  return (
    <div className="layout">
      <Layout>
        <Component {...pageProps} />
      </Layout>
    </div>
  );
};
export default App;
