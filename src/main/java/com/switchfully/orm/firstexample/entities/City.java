package com.switchfully.orm.firstexample.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {

    @Id
    private Long postalCode;
    private String name;

    public City() {
    }

    public City(Long id, String name) {
        this.postalCode = id;
        this.name = name;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "postalCode=" + postalCode +
                ", name='" + name + '\'' +
                '}';
    }
}
