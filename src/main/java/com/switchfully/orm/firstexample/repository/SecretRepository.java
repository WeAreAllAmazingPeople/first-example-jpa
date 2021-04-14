package com.switchfully.orm.firstexample.repository;

import com.switchfully.orm.firstexample.entities.Secret;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface SecretRepository extends CrudRepository<Secret, UUID> {
    //List<Secret> findAllBySecretOwnerName_FirstName(String firstName);
}
