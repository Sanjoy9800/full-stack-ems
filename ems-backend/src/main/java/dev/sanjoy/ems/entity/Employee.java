
package dev.sanjoy.ems.entity;

// Importing necessary packages for JPA annotations and Lombok
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok annotations to automatically generate boilerplate code
@Getter // Generates getter methods for all fields
@Setter // Generates setter methods for all fields
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with one argument for each field

// JPA annotations to map the class to a database table
@Entity // Specifies that the class is an entity and is mapped to a database table
@Table(name="employees") // Specifies the name of the database table to be used for mapping

public class Employee {

    // Primary key for the entity
    @Id // Specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indicates that the persistence provider must assign primary keys for the entity using a database identity column
    private long id; // Unique identifier for each employee

    // Column mappings for the fields
    @Column(name="first_name") // Specifies the mapped column for the 'firstName' field
    private String firstName; // Employee's first name

    @Column(name="last_name") // Specifies the mapped column for the 'lastName' field
    private String lastName; // Employee's last name

    @Column(name="email_id", nullable = false, unique = true) // Specifies the mapped column for the 'email' field, and sets constraints: 'nullable' to false and 'unique' to true
    private String email; // Employee's email address, must be unique and not null

    // The Lombok annotations (@Getter, @Setter, @NoArgsConstructor, @AllArgsConstructor) eliminate the need to manually write boilerplate code such as getter/setter methods and constructors.

    // The @Entity annotation indicates that this class is a JPA entity and will be mapped to a database table.

    // The @Table annotation specifies the name of the table in the database that this entity will be mapped to.

    // The @Id annotation marks the 'id' field as the primary key.

    // The @GeneratedValue annotation with the strategy GenerationType.IDENTITY indicates that the ID should be generated automatically by the database.

    // The @Column annotations specify the details of the columns that the fields will be mapped to, including their names in the database table.
}
