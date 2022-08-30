package com.example.myfirst.service;

import com.example.myfirst.dao.PersonDAO;
import com.example.myfirst.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public  int addPerson(Person person){

       return personDAO.insertPerson(person);

    }
    public List<Person> getAllPerson(){
        return personDAO.getAllPeople();
    }
}
