package org.hbn.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hbn.Entity.Employee;

import java.util.Optional;

@Transactional
public class EmployeeRepositoryImp implements EmployeeRepository {
    private EntityManager entityManager;

    public EmployeeRepositoryImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Employee> save(Employee employee) {
        try {
            entityManager.getTransaction().begin();
            if (employee.getId() == null) {
                entityManager.persist(employee);
            } else {
                entityManager.merge(employee);
            }
            entityManager.getTransaction().commit();
            return Optional.of(employee);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getCause();
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public Optional<Employee> getEmployeeByID(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee != null ? Optional.of(employee) : Optional.empty();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        if (entityManager.contains(employee)) {
            entityManager.remove(employee);
        } else {
            entityManager.merge(employee);
        }
        entityManager.getTransaction().commit();
        System.out.println("the employee is deleted ");
    }
}
