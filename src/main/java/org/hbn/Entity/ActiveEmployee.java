package org.hbn.Entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.hbn.Utils.Exceptions.Exceptions;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ActiveEmployee  extends Employee{

    @Column
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Salary> salaryList=new ArrayList<>();

    @Transient
    private Double totalCompensation;

    public ActiveEmployee(){}

    public ActiveEmployee(List<Salary> salaryList, Double totalCompensation) {
        this.salaryList = salaryList;
        this.totalCompensation = totalCompensation;
    }

    public ActiveEmployee(Long id, String fname, String lname, String nationalCode, List<Salary> salaryList, Double totalCompensation) throws Exceptions.InvalidEmployeeName, Exceptions.InvalidNationalCode {
        super(id, fname, lname, nationalCode);
        this.salaryList = salaryList;
        this.totalCompensation = totalCompensation;
    }

    public List<Salary> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<Salary> salaryList) {
        this.salaryList = salaryList;
    }

    public Double getTotalCompensation() {
        return totalCompensation;
    }

    public void setTotalCompensation(Double totalCompensation) {
        this.totalCompensation = totalCompensation;
    }
}
