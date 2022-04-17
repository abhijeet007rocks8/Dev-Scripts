import React from "react";
import { Provider } from "react-redux";
import { PersistGate } from "redux-persist/lib/integration/react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import TemplateProvider from "./templates/TemplateProvider";
import store, { persistor } from "./store";
import App from "./App";
import "./index.css";

ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <TemplateProvider>
        <BrowserRouter>
          <PersistGate persistor={persistor}>
            <App />
          </PersistGate>
        </BrowserRouter>
      </TemplateProvider>
    </Provider>
  </React.StrictMode>,
  document.getElementById("root")
);
