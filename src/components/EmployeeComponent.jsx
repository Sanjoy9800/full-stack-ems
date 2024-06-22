import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { deleteEmployee, listEmployees } from "../services/EmployeeServices";

const EmployeeComponent = () => {
  const [employee, setEmployee] = useState([]);

  const navigate = useNavigate();

  useEffect(() => {
    getAllEmployee();
  }, []);

  const getAllEmployee = () => {
    listEmployees()
      .then((res) => {
        setEmployee(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const addEmployee = () => {
    navigate("/addEmployee");
  };

  const updateEmployee = (id) => {
    navigate(`/update_employee/${id}`);
  };

  function removeEmployee(id) {
    console.log(id);

    deleteEmployee(id)
      .then((res) => {
        getAllEmployee();
      })
      .catch((error) => console.log(error));
  }

  return (
    <div className="container">
      <h2 className="text-center pb-3 text-nowrap">List of Employees</h2>
      <div className="d-flex justify-content-center mb-4">
        <button type="button" className="btn btn-primary" onClick={addEmployee}>
          Add Employee
        </button>
      </div>
      <table className="table table-striped table-hover table-bordered">
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Employee Firstname</th>
            <th>Employee Lastname</th>
            <th>Employee Email</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {employee.map((emp) => (
            <tr key={emp.id}>
              <td>{emp.id}</td>
              <td>{emp.firstName}</td>
              <td>{emp.lastName}</td>
              <td>{emp.email}</td>
              <td>
                <button
                  className="btn btn-info"
                  onClick={() => updateEmployee(emp.id)}
                >
                  Update
                </button>
                <button
                  className="btn btn-danger"
                  onClick={() => removeEmployee(emp.id)}
                  style={{marginLeft:"10px"}}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default EmployeeComponent;
