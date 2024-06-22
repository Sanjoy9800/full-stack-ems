//package dev.sanjoy.ems.service.impl;
//
//import dev.sanjoy.ems.dto.EmployeeDto;
//import dev.sanjoy.ems.entity.Employee;
//import dev.sanjoy.ems.exception.ResourceNotFoundException;
//import dev.sanjoy.ems.mapper.EmployeeMapper;
//import dev.sanjoy.ems.repository.EmployeeRepository;
//import dev.sanjoy.ems.service.EmployeeService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//// Indicates that this class is a service component in the Spring context
//@Service
//
//// Generates a constructor with one parameter for each field
//@AllArgsConstructor
//public class EmployeeServiceImpl implements EmployeeService {
//
//    // Dependency for interacting with the database
//    private EmployeeRepository employeeRepository;
//
//    // Implementation of the createEmployee method
//    @Override
//    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
//
//        // Map EmployeeDto to Employee entity
//        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
//        // Save the Employee entity to the repository
//        Employee savedEmployee = employeeRepository.save(employee);
//
//        // Map the saved Employee entity back to EmployeeDto and return it
//        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
//    }
//
//    @Override
//    public EmployeeDto getEmployeeById(Long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("Employee is not exits with given id: " + employeeId ));
//        return EmployeeMapper.mapToEmployeeDto(employee);
//    }
//
//    @Override
//    public List<EmployeeDto> getAllEmployees() {
//       List<Employee> employees = employeeRepository.findAll();
//        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
//        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
//                () -> new ResourceNotFoundException("Employee is not exists with given id:" + employeeId)
//        );
//
//        employee.setFirstName(updatedEmployee.getFirstName());
//        employee.setLastName(updatedEmployee.getLastName());
//        employee.setEmail(updatedEmployee.getEmail());
//
//        Employee updatedEmployeeObj = employeeRepository.save(employee);
//        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
//    }
//
//    @Override
//    public void deleteEmployee(Long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
//                () -> new ResourceNotFoundException("Employee is not exists with given id:" + employeeId)
//        );
//
//        employeeRepository.deleteById(employeeId);
//    }
//}





package dev.sanjoy.ems.service.impl;

import dev.sanjoy.ems.dto.EmployeeDto;
import dev.sanjoy.ems.entity.Employee;
import dev.sanjoy.ems.exception.ResourceNotFoundException;
import dev.sanjoy.ems.mapper.EmployeeMapper;
import dev.sanjoy.ems.repository.EmployeeRepository;
import dev.sanjoy.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Indicates that this class is a service component in the Spring context
@Service
// Generates a constructor with one parameter for each field (dependency injection)
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    // Dependency for interacting with the database
    private EmployeeRepository employeeRepository;

    // Implementation of the createEmployee method
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Map EmployeeDto to Employee entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        // Save the Employee entity to the repository
        Employee savedEmployee = employeeRepository.save(employee);
        // Map the saved Employee entity back to EmployeeDto and return it
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    // Implementation of the getEmployeeById method
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        // Find the employee by ID, throw an exception if not found
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId ));
        // Map the found Employee entity to EmployeeDto and return it
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    // Implementation of the getAllEmployees method
    @Override
    public List<EmployeeDto> getAllEmployees() {
        // Retrieve all Employee entities from the repository
        List<Employee> employees = employeeRepository.findAll();
        // Map each Employee entity to EmployeeDto and collect them into a list
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    // Implementation of the updateEmployee method
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        // Find the employee by ID, throw an exception if not found
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId)
        );

        // Update the employee's fields with values from updatedEmployee DTO
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        // Save the updated Employee entity to the repository
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        // Map the updated Employee entity to EmployeeDto and return it
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    // Implementation of the deleteEmployee method
    @Override
    public void deleteEmployee(Long employeeId) {
        // Find the employee by ID, throw an exception if not found
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId)
        );

        // Delete the employee by ID
        employeeRepository.deleteById(employeeId);
    }
}
