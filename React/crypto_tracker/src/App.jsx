import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import { Header } from "./components/Header";
import { Coinpage } from "./pages/Coinpage";
import { Homepage } from "./pages/Homepage";
import { makeStyles } from '@material-ui/core/styles';
import { Footer } from "./components/Footer";

function App() {

  const useStyles = makeStyles((theme) => ({
    App: {
      backgroundColor: '#14161A',
      color: '#fff',
      minHeight: '100vh',
    }
  }));

  const classes = useStyles();

  return (
    <BrowserRouter>
      <div className={classes.App}>
        <Header />
        <Routes>
          <Route path="/" element={<Homepage />} />
          <Route path="/coins/:id" element={<Coinpage />} />
        </Routes>
        <Footer/>
      </div>

    </BrowserRouter>
  );
}

export default App;
