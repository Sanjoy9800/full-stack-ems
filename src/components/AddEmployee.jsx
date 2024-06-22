import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { createEmployee, getEmployee } from "../services/EmployeeServices";

const AddEmployee = () => {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    email: "",
  });

  const { id } = useParams();
  const navigate = useNavigate();



  useEffect(()=>{
    if(id){
        getEmployee(id).then((res)=>{
        setFormData(res.data)
        }).catch((error)=>{
            console.log("error fetching employee data", error);
        })
    }
  },[id])

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const employee = { ...formData };
    console.log("Form data submitted:", formData);
    
    createEmployee(employee)
      .then((res) => {
        console.log(res.data);
        navigate("/employees");
      })
      .catch((error) => {
        console.log("Error creating employee:", error);
      });
  };

  const pageTitle = () => {
    if (id) {
      return <h5 className="card-title text-center fw-bold">Update Employee</h5>;
    } else {
      return <h5 className="card-title text-center fw-bold">Add Employee</h5>;
    }
  };

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          <div className="card-body">
            {pageTitle()}
            <form onSubmit={handleSubmit}>
              <div className="form-group">
                <label htmlFor="firstName">First Name:</label>
                <input
                  type="text"
                  className="form-control"
                  id="firstName"
                  name="firstName"
                  value={formData.firstName}
                  onChange={handleInputChange}
                  required
                />
              </div>
              <div className="form-group">
                <label htmlFor="lastName">Last Name:</label>
                <input
                  type="text"
                  className="form-control"
                  id="lastName"
                  name="lastName"
                  value={formData.lastName}
                  onChange={handleInputChange}
                  required
                />
              </div>
              <div className="form-group">
                <label htmlFor="email">Email:</label>
                <input
                  type="email"
                  className="form-control"
                  id="email"
                  name="email"
                  value={formData.email}
                  onChange={handleInputChange}
                  required
                />
              </div>
              <button type="submit" className="btn btn-primary mt-3 w-100">
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddEmployee;
