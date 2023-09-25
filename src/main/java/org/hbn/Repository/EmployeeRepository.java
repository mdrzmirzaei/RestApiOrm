package org.hbn.Repository;

import org.hbn.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> save(Employee employee);

    Optional<Employee> getEmployeeByID(Long id);

    void deleteEmployee(Employee employee);

    List<Employee> findByName(String name);

}
