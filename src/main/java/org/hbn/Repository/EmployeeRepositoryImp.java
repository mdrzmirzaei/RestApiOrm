package org.hbn.Repository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.hbn.Entity.Employee;

import java.util.List;
import java.util.Optional;



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
                if (employee.getEmployeeProfile() != null)
                    entityManager.persist(employee.getEmployeeProfile());
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


    @Override
    public List<Employee> findByName(String name) {
        Query query=entityManager.createQuery("select emp from Employee as emp where emp.fname = :entername");
        query.setParameter("entername",name);
        List employeeList=query.getResultList();
        return employeeList;
    }
}
