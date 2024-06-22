//
//
//package dev.sanjoy.ems.service;
//
//import dev.sanjoy.ems.dto.EmployeeDto;
//
//import java.util.List;
//
//public interface EmployeeService {
//    // Method to create a new employee
//    EmployeeDto createEmployee(EmployeeDto employeeDto);
//
//    EmployeeDto getEmployeeById(Long employeeId);
//
//    List<EmployeeDto> getAllEmployees();
//
//
//    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
//
//
//
//    void deleteEmployee(Long employeeId);
//
//}



package dev.sanjoy.ems.service;

import dev.sanjoy.ems.dto.EmployeeDto;

import java.util.List;

// Interface for Employee Service containing methods for employee operations
public interface EmployeeService {

    // Method to create a new employee
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    // Method to get an employee by their ID
    EmployeeDto getEmployeeById(Long employeeId);

    // Method to get a list of all employees
    List<EmployeeDto> getAllEmployees();

    // Method to update an employee's details
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    // Method to delete an employee by their ID
    void deleteEmployee(Long employeeId);
}

