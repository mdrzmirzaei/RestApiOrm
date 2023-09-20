package org.hbn.Repository;

import jakarta.persistence.EntityManager;
import org.hbn.Entity.Salary;

import java.util.Optional;

public class SalaryRepositoryImp implements SalaryRepository {

    private EntityManager entityManager;

    @Override
    public Optional<Salary> save(Salary salary) {
        try {
            entityManager.getTransaction().begin();
            if (salary.getId() == null) {
                entityManager.persist(salary);
            } else {
                entityManager.merge(salary);
            }
            entityManager.getTransaction().commit();
            return Optional.of(salary);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getCause();
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Salary> getSalaryID(Long id) {
        Salary salary = entityManager.find(Salary.class, id);
        return salary != null ? Optional.of(salary) : Optional.empty();
    }

    @Override
    public void deleteSalary(Salary salary) {
        entityManager.getTransaction().begin();
        if (entityManager.contains(salary)) {
            entityManager.remove(salary);
        } else {
            entityManager.merge(salary);
        }
        entityManager.getTransaction().commit();
    }
}