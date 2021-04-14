package com.switchfully.orm.firstexample;

import com.switchfully.orm.firstexample.entities.*;
import com.switchfully.orm.firstexample.repository.CityRepository;
import com.switchfully.orm.firstexample.repository.PersonRepository;
import com.switchfully.orm.firstexample.repository.SecretRepository;
import com.switchfully.orm.firstexample.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FirstExampleApplication implements CommandLineRunner {
    private PersonService personService;
    private PersonRepository personRepository;
    private CityRepository cityRepository;
    private SecretRepository secretRepository;

    public FirstExampleApplication(PersonService service, PersonRepository personRepository, CityRepository cities, SecretRepository secretRepository) {
        this.personService = service;
        this.personRepository = personRepository;
        this.cityRepository = cities;
        this.secretRepository = secretRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        City leuven = cityRepository.save(new City(3000L, "Leuven"));
        City tienen = cityRepository.save(new City(3300L, "Tienen"));


        Person karel = new Person();
        karel.setName(new Name("Karel", "Van Roey"));
        karel.setEmail(new Email("karel@switchfully.com"));
        //karel.setCity(new City(1000L, "Brussel"));
        karel.setCity(leuven);
        //personService.add(karel);
        personRepository.save(karel);

        Person ihsan = new Person();
        ihsan.setName(new Name("Ihsan", "Dinc"));
        ihsan.setEmail(new Email("ihsan@fodfin.be"));
        ihsan.setCity(cityRepository.findById(3300L).get());
        personRepository.save(ihsan);

        System.out.println("Does someone live in Tienen?"  + personRepository.existsPersonByCity_PostalCode(3000L));


        personRepository.findAllByName_FirstNameStartsWith("K")
                .forEach(System.out::println);

        System.out.println("--------------------------------------");
        secretRepository.saveAll(
                List.of(
                        new Secret("I like java", karel),
                        new Secret("Violets are blue", karel)
                )
        );

        personRepository.delete(karel);


        //cities.save(new City(3000L, "Leuven"));
//        //System.out.println(service.getByFirstName("Chris"));
//        Person lis = new Person();
//        lis.setId(22);
//        lis.setFirstName("Lis");
//        lis.setLastName("Verheyden");
//
//        //service.add(lis);
//
//        service.changeLastName(5, "B");
//        //System.out.println(result);
////
//        service.getAll().forEach(System.out::println);
////
////        Person lis = service.getByFirstName("Lis");
////        service.remove(lis);
//
////        service.removeByFirstName("Lis");
    }
}
