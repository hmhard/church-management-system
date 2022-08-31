package com.example.myfirst.dao;

import com.example.myfirst.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDAO")
public class FakePersonAccessService implements PersonDAO{
    List<Person> DB= new ArrayList<>();

    public int insertPerson(Long id, Person person) {
        DB.add(new Person(id,person.getFirstName()));
        return 1;

    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> getSinglePersonById(UUID id) {
        return Optional.empty();
    }


}
