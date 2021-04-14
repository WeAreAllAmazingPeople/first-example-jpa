package com.switchfully.orm.firstexample.repository;

import com.switchfully.orm.firstexample.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {
    List<Person> findAllByName_FirstNameStartsWith(String firstName);

    boolean existsPersonByCity_PostalCode(Long postalCode);
}
