package com.switchfully.orm.firstexample;

import com.switchfully.orm.firstexample.entities.Person;
import com.switchfully.orm.firstexample.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstExampleApplication implements CommandLineRunner {
    private PersonService service;

    public FirstExampleApplication(PersonService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println(service.getByFirstName("Chris"));
        Person lis = new Person();
        lis.setId(22);
        lis.setFirstName("Lis");
        lis.setLastName("Verheyden");

        service.add(lis);

        service.changeLastName(5, "B");
        //System.out.println(result);
//
        service.getAll().forEach(System.out::println);
//
//        Person lis = service.getByFirstName("Lis");
//        service.remove(lis);

//        service.removeByFirstName("Lis");
    }
}
