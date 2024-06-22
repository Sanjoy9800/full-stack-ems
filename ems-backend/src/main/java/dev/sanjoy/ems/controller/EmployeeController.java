//package dev.sanjoy.ems.controller;
//
//import dev.sanjoy.ems.dto.EmployeeDto;
//import dev.sanjoy.ems.service.EmployeeService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/employees")
//@AllArgsConstructor
//public class EmployeeController {
//    private EmployeeService employeeService;
//
//
//    // build add Employee REST API
//
//    @PostMapping
//    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
//        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
//        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
//    }
//
//
//
//    // build a get Employee REST API
//
//    @GetMapping("{id}")
//    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
//        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
//            return ResponseEntity.ok(employeeDto);
//
//    }
//
//
//    // build getAlleEmployees REST api
//
//
//    @GetMapping
//    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
//       List<EmployeeDto> employees = employeeService.getAllEmployees();
//       return ResponseEntity.ok(employees);
//    }
//
//
//
//    //build updateEmployee rest api
//    @PutMapping("{id}")
//    public  ResponseEntity<EmployeeDto> updateEmployee( @PathVariable("id") Long employeeId,
//                                                        @RequestBody EmployeeDto updatedEmployee){
//       EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
//
//       return ResponseEntity.ok(employeeDto);
//    }
//
//
//
//       //Build deleteEmployee Rest Api
//
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
//        employeeService.deleteEmployee(employeeId);
//        return ResponseEntity.ok("Employee has been deleted successfully!.");
//    }
//}
//
//
//




package dev.sanjoy.ems.controller;

import dev.sanjoy.ems.dto.EmployeeDto;
import dev.sanjoy.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
// Indicates that this class is a REST controller in the Spring context
@RestController
// Base URL for all endpoints in this controller
@RequestMapping("/api/employees")
// Generates a constructor with one parameter for each field (dependency injection)
@AllArgsConstructor
public class EmployeeController {

    // Dependency for the EmployeeService
    private EmployeeService employeeService;

    // Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        // Calls the service method to create an employee and returns the saved employee with status CREATED
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get Employee by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        // Calls the service method to get an employee by ID and returns the employee DTO with status OK
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    // Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        // Calls the service method to get all employees and returns the list of employee DTOs with status OK
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updatedEmployee) {
        // Calls the service method to update an employee and returns the updated employee DTO with status OK
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    // Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        // Calls the service method to delete an employee by ID and returns a success message with status OK
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee has been deleted successfully!");
    }
}
