package org.hbn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hbn.Entity.Employee;


public class Main {
    public static void main(String[] args) {
        System.out.println("pls wait...");
        try {
            Employee e = new Employee("alie", "bali", "0078061218");
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(e);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch
        (Exception e) {
            System.out.println(e.getMessage());
            e.getCause();
            e.getStackTrace();
        }

    }
}
