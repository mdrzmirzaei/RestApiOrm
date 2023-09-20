package org.hbn.Repository;

import org.hbn.Entity.Employee;
import org.hbn.Entity.Salary;

import java.util.Optional;

public interface SalaryRepository {
    Optional<Salary> save(Salary salary);

    Optional<Salary> getSalaryID(Long id);

    void deleteSalary(Salary salary);


}
