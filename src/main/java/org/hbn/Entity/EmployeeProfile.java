package org.hbn.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class EmployeeProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String email;

    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public EmployeeProfile() {

    }

    public EmployeeProfile(Long id, String userName, String password, String email, Employee employee) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.employee = employee;
    }

}
