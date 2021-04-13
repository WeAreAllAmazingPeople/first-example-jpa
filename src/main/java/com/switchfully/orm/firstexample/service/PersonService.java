package com.switchfully.orm.firstexample.service;

import com.switchfully.orm.firstexample.entities.Person;
import com.switchfully.orm.firstexample.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {
    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }


    public Person getByFirstName(String firstName) {
        return repository.getByFirstName(firstName);
    }

    public void add(Person person) {
        repository.add(person);
    }

    public Person findById(int id) {
        return repository.findById(id);
    }

    public List<Person> getAll() {
     return repository.getAll();
    }

    public void remove(Person person) {
        repository.remove(person);
    }

    public void changeLastName(int id, String newLastName) {
        Person result = repository.findById(id);
        result.setLastName(newLastName);
        // no code here
    }

    public void removeByFirstName(String firstName) {
        Person personToRemove = repository.getByFirstName(firstName);
        repository.remove(personToRemove);
    }
}
