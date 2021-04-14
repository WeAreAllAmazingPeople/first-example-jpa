package com.switchfully.orm.firstexample.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;
    @Embedded
    private Name name;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "email_email")
    private Email email;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", city=" + city +
                '}';
    }
}
