package com.switchfully.orm.firstexample;

import com.switchfully.orm.firstexample.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstExampleApplication implements CommandLineRunner {
    private PersonRepository repository;

    public FirstExampleApplication(PersonRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(repository.getByFirstName("Chris"));
        //repository.getAll().forEach(System.out::println);
    }
}
