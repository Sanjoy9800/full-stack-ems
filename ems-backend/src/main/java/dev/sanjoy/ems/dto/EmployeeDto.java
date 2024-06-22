//package dev.sanjoy.ems.dto;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//
//
//public class EmployeeDto {
//    private long id;
//    private String firstName;
//    private String lastName;
//    private String email;
//}



package dev.sanjoy.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok annotation to generate getter methods for all fields
@Getter
// Lombok annotation to generate setter methods for all fields
@Setter
// Lombok annotation to generate a no-argument constructor
@NoArgsConstructor
// Lombok annotation to generate a constructor with one parameter for each field
@AllArgsConstructor

// Data Transfer Object (DTO) for Employee
public class EmployeeDto {

    // Unique identifier for the employee
    private long id;

    // Employee's first name
    private String firstName;

    // Employee's last name
    private String lastName;

    // Employee's email address
    private String email;
}
