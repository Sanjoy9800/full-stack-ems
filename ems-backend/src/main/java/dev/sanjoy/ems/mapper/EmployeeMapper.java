
//Converting Entity to DTO:(Data Transfer Object)
//
//        The mapToEmployeeDto method is used to convert an Employee entity object to an EmployeeDto object.
//        This is typically used when sending data from the backend to the frontend, ensuring that only necessary
//        data is transferred and used.
//
//
//        Converting DTO to Entity:
//
//        The mapToEmployee method is used to convert an EmployeeDto object to an Employee entity object.
//        This is useful when receiving data from the frontend, allowing the backend to convert the DTO to an entity
//        that can be persisted in the database.



package dev.sanjoy.ems.mapper;

import dev.sanjoy.ems.dto.EmployeeDto;
import dev.sanjoy.ems.entity.Employee;

// EmployeeMapper class to map between Employee and EmployeeDto
public class EmployeeMapper {

    // Method to convert Employee entity to EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        // Create and return a new EmployeeDto object using the properties from the Employee entity
        return new EmployeeDto(
                employee.getId(),             // Set the id
                employee.getFirstName(),      // Set the first name
                employee.getLastName(),       // Set the last name
                employee.getEmail()           // Set the email
        );
    }

    // Method to convert EmployeeDto to Employee entity
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        // Create and return a new Employee entity using the properties from the EmployeeDto
        return new Employee(
                employeeDto.getId(),          // Set the id
                employeeDto.getFirstName(),   // Set the first name
                employeeDto.getLastName(),    // Set the last name
                employeeDto.getEmail()        // Set the email
        );
    }
}
