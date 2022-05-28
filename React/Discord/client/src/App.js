import React from "react";

import { BrowserRouter, Route, Routes } from "react-router-dom";

import Dashboard from "./components/dashboard/Dashboard";
import DemoLoginPage from "./components/authForm/DemoLoginPage";
import LoginPage from "./components/authForm/LoginPage";
import SignupPage from "./components/authForm/SignupPage";
import { RequireAuth } from "./routes";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<DemoLoginPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<SignupPage />} />
        <Route
          path="/channels/:channel"
          element={
            <RequireAuth>
              <Dashboard />
            </RequireAuth>
          }
        />
      </Routes>
    </BrowserRouter>
  );
};

export default App;
