import React from "react";

const Header = () => {
  return (
    <div>
      <header className="text-center">
        <nav className="navbar navbar-dark bg-dark">
          <div className="container d-flex justify-content-center">
            <a className="navbar-brand fw-bold" href="#">
              Employee Management System
            </a>
          </div>
        </nav>
      </header>
    </div>
  );
};

export default Header;
