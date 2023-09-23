package org.hbn.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class EmployeeProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ep_id")
    private Long id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String email;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;

    public EmployeeProfile() {

    }

    public EmployeeProfile(Long id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
