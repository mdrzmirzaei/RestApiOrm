package org.hbn.Entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Companies")
public class Company implements Serializable {

    @Id
    @Column(name = "cmp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cmp_name")
    private String name;

    @Column(name = "cmp_city")
    private String city;

    @Column(name = "cmp_state")
    private String state;

    @Column(name = "cmp_country")
    private String country;

    public Company(){}

    public Company(Long id, String name, String city, String state, String country) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
