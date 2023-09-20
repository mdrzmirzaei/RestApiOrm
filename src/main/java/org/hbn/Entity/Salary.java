package org.hbn.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

;
@Entity
@Table(name = "salaries")
public class Salary implements Serializable {
    @Id
    @Column(name = "sal_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer bonusPercentage;

    @Column
    private Double stratingSalary;

    @Column
    Double currentSalary;
    @Column
    private  Boolean activeFlag;

    @Column
    String title;

    public Salary(){}

    public Salary(Long id, Integer bonusPercentage, Double stratingSalary, Double currentSalary, Boolean activeFlag, String title) {
        this.id = id;
        this.bonusPercentage = bonusPercentage;
        this.stratingSalary = stratingSalary;
        this.currentSalary = currentSalary;
        this.activeFlag = activeFlag;
        this.title = title;
    }

    public Salary(Double currentSalary, Boolean activeFlag) {
        this.currentSalary = currentSalary;
        this.activeFlag = activeFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(Integer bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    public Double getStratingSalary() {
        return stratingSalary;
    }

    public void setStratingSalary(Double stratingSalary) {
        this.stratingSalary = stratingSalary;
    }

    public Double getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(Double currentSalary) {
        this.currentSalary = currentSalary;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

