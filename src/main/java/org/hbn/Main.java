package org.hbn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import org.hbn.Entity.Employee;
import org.hbn.Repository.EmployeeRepositoryImp;

import java.util.Optional;

@Transactional
public class Main {

    public static void main(String[] args) {

        System.out.println("pls wait...");
        try {


            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EmployeeRepositoryImp employeeRepository=new EmployeeRepositoryImp(entityManager);

            Employee e = new Employee();
            e.setFname("hadi");
            e.setLname("zare");
            e.setNationalCode("0150660362");

            Optional<Employee> savedEmployees=employeeRepository.save(e);


            System.out.println("salllam halet khobe ????");
         //   entityManager.persist(e);
           // entityManager.persist(e2);


         //   entityManager.getTransaction().commit();


      //      entityManager.close();
       //     entityManagerFactory.close();

        } catch
        (Exception e) {
            System.out.println(e.getMessage());
            e.getCause();
            e.getStackTrace();
        }

    }
}
