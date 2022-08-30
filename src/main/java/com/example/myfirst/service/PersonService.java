package com.example.myfirst.service;

import com.example.myfirst.dao.PersonDAO;
import com.example.myfirst.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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


    public Person getSinglePersonByID(UUID id){
        return  personDAO.getSinglePersonById(id).orElse(null);
    }
}
