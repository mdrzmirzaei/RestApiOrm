package org.hbn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import org.hbn.Entity.Company;
import org.hbn.Entity.Employee;
import org.hbn.Entity.EmployeeProfile;
import org.hbn.Entity.Salary;
import org.hbn.Repository.EmployeeRepositoryImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
public class Main {

    private static List<Salary> generatSalaries() {
        Salary currentSalary = new Salary(34000.00, true);
        Salary historialSalary1 = new Salary(28000.00, false);
        Salary historialSalary2 = new Salary(18000.00, false);
        List<Salary> salaries = new ArrayList<>();
        salaries.add(currentSalary);
        salaries.add(historialSalary1);
        salaries.add(historialSalary2);
        return salaries;
    }

    public static List<Company> generateCompanies() {
        Company olderc = new Company("ناواکو", "تهران", "دبی");
        Company current = new Company("دوران", "تهران", "ایران");
        List<Company> companies = new ArrayList<>();
        companies.add(olderc);
        companies.add(current);
        return companies;
    }

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {


        System.out.println("pls wait...");
        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("default");
            entityManager = entityManagerFactory.createEntityManager();
            EmployeeRepositoryImp employeeRepository = new EmployeeRepositoryImp(entityManager);


            Employee employee = new Employee();
            employee.setFname("محمدرضا");
            employee.setLname("میرزایی");
            employee.setNationalCode("0078061210");


            EmployeeProfile ep = new EmployeeProfile();
            ep.setEmail("mdrz.mirzaei@gmail.com");
            ep.setPassword("123");
            ep.setUserName("amirza");
            ep.setEmployee(employee);
            employee.setEmployeeProfile(ep);
            employeeRepository.save(employee);




            // set Salaries data for current employee
            employee.setSalaryList(generatSalaries().stream().toList());

            //set companies data for current employee
            employee.setCompanies(generateCompanies().stream().toList());

            // persist current employee with data of profile,salaries & companies
            employeeRepository.save(employee);


/*         Employee e = new Employee();
            e.setFname("hadi");
            e.setLname("zare");
            e.setNationalCode("0150660362");

        Optional<Employee> savedEmployees=employeeRepository.save(e);

            */


/*           for (int i = 0; i < generatSalaries().size(); i++) {
                System.out.println("   current Salary is : " + generatSalaries().get(i).getCurrentSalary() + "     Flag is : " + generatSalaries().get(i).getActiveFlag());
                entityManager.persist(generatSalaries().get(i));

            }

 */

           /* Optional<Employee> employee1 = employeeRepository.getEmployeeByID(81L);
            if (employee1.isPresent()) {
                System.out.println(employee1.get().getFname());
                System.out.println(employee1.get().getLname());
                }
*/


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
