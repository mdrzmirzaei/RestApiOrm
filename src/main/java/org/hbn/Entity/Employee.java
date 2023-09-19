package org.hbn.Entity;

import jakarta.persistence.*;
import org.hbn.Utils.Exceptions.Exceptions;
import org.hbn.Utils.IranUtils.CheckNationalCode;

import java.io.Serializable;

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
}
