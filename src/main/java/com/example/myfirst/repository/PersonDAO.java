package com.example.myfirst.repository;

import com.example.myfirst.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {
    int insertPerson(UUID id, Person person);

    default  int insertPerson(Person person){
        UUID id= UUID.randomUUID();
        return  insertPerson(id,person);

    }
    List<Person> getAllPeople();
   Optional<Person> getSinglePersonById(UUID id);
}