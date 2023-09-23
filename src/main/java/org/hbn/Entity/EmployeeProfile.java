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

    public EmployeeProfile() {

    }

    public EmployeeProfile(Long id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

}
