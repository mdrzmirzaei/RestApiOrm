package org.hbn.Repository;

import org.hbn.Entity.Employee;

import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> save(Employee employee);

//    Optional<Employee> getEmployeeByID(Employee employee);


}
