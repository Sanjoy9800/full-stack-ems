import React from "react";
import "./App.css";
import EmployeeComponent from "./components/EmployeeComponent";
import Header from "./components/Header";
import Footer from "./components/Footer";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import AddEmployee from "./components/AddEmployee";

function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<EmployeeComponent />} />
          <Route path="/employees" element={<EmployeeComponent/>}/>
          <Route path="/addEmployee" element={<AddEmployee/>}/>
          <Route path="/update_employee/:id" element={<AddEmployee/>}/>
        </Routes>
        <Footer />
      </BrowserRouter>
    </>
  );
}

export default App;
