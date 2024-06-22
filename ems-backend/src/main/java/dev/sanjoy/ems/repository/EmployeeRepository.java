package dev.sanjoy.ems.repository;

import dev.sanjoy.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * The EmployeeRepository interface is a data access layer for the Employee entity.
 * It extends JpaRepository which is part of the Spring Data JPA library.
 *
 * By extending JpaRepository, this interface inherits several methods for working
 * with Employee persistence, such as:
 *
 * - save(): Saves a given entity.
 * - findById(): Retrieves an entity by its id.
 * - findAll(): Returns all instances of the type.
 * - delete(): Deletes a given entity.
 * - and many more...
 *
 * JpaRepository<Employee, Long> means that this repository will work with
 * Employee entities and the ID type of Employee is Long.
 *
 * This interface doesn't require any method implementation as Spring Data JPA
 * will automatically provide the implementation at runtime.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
