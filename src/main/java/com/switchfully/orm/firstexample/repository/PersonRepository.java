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

    // C => CREATE => 1
    public void add(Person person) {
        entityManager.persist(person);

    }

    // R => READ => 3. 10, 20, 30
    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> getAll() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    public Person getByFirstName(String firstName) {
        return entityManager.createQuery("select p from Person p where p.firstName like concat(:firstName, '%')", Person.class)
                .setParameter("firstName", firstName)
                .setMaxResults(1)
                .getSingleResult();
    }

// U => Update => 0

    // D => Delete => 1
    public void remove(Person person) {
        entityManager.remove(person);
    }
}
