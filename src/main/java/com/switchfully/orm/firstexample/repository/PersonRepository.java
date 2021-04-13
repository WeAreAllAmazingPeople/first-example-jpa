package com.switchfully.orm.firstexample.repository;

import com.switchfully.orm.firstexample.entities.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getAll(){
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    public Person getByFirstName(String firstName) {
        return entityManager.createQuery("select p from Person p where p.firstName like concat(:firstName, '%')", Person.class)
                .setParameter("firstName", firstName)
                .setMaxResults(1)
                .getSingleResult();
    }
}
