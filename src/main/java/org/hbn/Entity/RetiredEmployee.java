package org.hbn.Entity;

import jakarta.persistence.Entity;
import org.hbn.Utils.Exceptions.Exceptions;

@Entity
public class RetiredEmployee extends Employee {

    private Boolean pension;
    private Integer yearsOfService;

    public RetiredEmployee() {}

    public RetiredEmployee(Long id, String fname, String lname, String nationalCode, Boolean pension, Integer yearsOfService) throws Exceptions.InvalidEmployeeName, Exceptions.InvalidNationalCode {
        super(id, fname, lname, nationalCode);
        this.pension = pension;
        this.yearsOfService = yearsOfService;
    }
}
