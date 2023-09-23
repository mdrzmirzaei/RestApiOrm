package org.hbn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import org.hbn.Entity.Employee;
import org.hbn.Entity.Salary;
import org.hbn.Repository.EmployeeRepositoryImp;

import java.util.Optional;

@Transactional
public class Main {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {


        System.out.println("pls wait...");
        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("default");
            entityManager = entityManagerFactory.createEntityManager();
            EmployeeRepositoryImp employeeRepository = new EmployeeRepositoryImp(entityManager);

            /*
      Employee employee=new Employee();
      employee.setFname("محمدرضا");
      employee.setLname("میرزایی");
      employee.setNationalCode("0078061210");

      employee.setSalary(new Salary((54000.00,true)));


      employeeRepository.save(employee);

         Employee e = new Employee();
            e.setFname("hadi");
            e.setLname("zare");
            e.setNationalCode("0150660362");

            Optional<Employee> savedEmployees=employeeRepository.save(e);

*/
            Optional<Employee> employee1 = employeeRepository.getEmployeeByID(81L);
            if (employee1.isPresent()) {
                System.out.println(employee1.get().getFname());
                System.out.println(employee1.get().getLname());

            }

        } catch
        (Exception e) {
            System.out.println(e.getMessage());
            e.getCause();
            e.getStackTrace();
        } finally {
       //     entityManager.close();
         //   entityManagerFactory.close();
            System.out.println("the end!!!!!!!");
        }

    }
}
