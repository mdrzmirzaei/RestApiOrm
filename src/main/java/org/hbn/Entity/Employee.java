package org.hbn.Entity;

import jakarta.persistence.*;
import org.hbn.Utils.Exceptions.Exceptions;
import org.hbn.Utils.IranUtils.CheckNationalCode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hbn.Entity.EmployeeProfile;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long id;
    @Column(name = "emp_name", length = 25)

    private String fname;
    @Column(name = "emp_family", length = 35)
    private String lname;
    @Column(name = "emp_nationalCode", length = 10, unique = true)
    private String nationalCode;

    @OneToOne(mappedBy ="employee",cascade = CascadeType.ALL)
    private EmployeeProfile employeeProfile;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "emp_id")
    private List<Salary> salary=new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "Emplyee_Company", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "com_id"))
    private List<Company> company= new ArrayList<>();

    public Employee() {
    }

    public Employee(Long id,String fname, String lname, String nationalCode) throws Exceptions.InvalidEmployeeName, Exceptions.InvalidNationalCode {
        this.id=id;
        setFname(fname);
        setLname(lname);
        setNationalCode(nationalCode);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) throws Exceptions.InvalidEmployeeName {

        fname = fname.replaceAll("[*0-9]", "");

        if (fname.length() < 3 || fname.isBlank())
            throw new Exceptions.InvalidEmployeeName("EmployeeName is blank or less than of 3 charachters");
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) throws Exceptions.InvalidEmployeeName {
        lname = lname.replaceAll("[*0-9]", "");

        if (lname.length() < 3 || lname.isBlank()) {
            throw new Exceptions.InvalidEmployeeName("EmployeeName is blank or less than of 3 charachters");
        }
        this.lname = lname;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) throws Exceptions.InvalidNationalCode {
        nationalCode = nationalCode.replaceAll("[^\\d.]", "");
        CheckNationalCode checkNationalCode=new CheckNationalCode();
        if (!checkNationalCode.checkNationalCode(nationalCode))
            throw new Exceptions.InvalidNationalCode("your nationalcode is invalid!!");
        this.nationalCode = nationalCode;
    }

    public List<Salary> getSalary() {
        return salary;
    }

    public void setSalary(List<Salary> salary) {
        this.salary = salary;
    }

    public List<Company> getCompany() {
        return company;
    }

    public void setCompany(List<Company> company) {
        this.company = company;
    }

    public EmployeeProfile getEmployeeProfile() {
        return employeeProfile;
    }

    public void setEmployeeProfile(EmployeeProfile employeeProfile) {
        this.employeeProfile = employeeProfile;
    }
}
