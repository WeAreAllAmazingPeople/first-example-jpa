package com.switchfully.orm.firstexample.repository;

import com.switchfully.orm.firstexample.entities.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
}
