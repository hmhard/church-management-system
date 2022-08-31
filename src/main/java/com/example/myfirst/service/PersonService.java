package com.example.myfirst.service;

import com.example.myfirst.dao.PersonDAO;
import com.example.myfirst.dao.PersonRepository;
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

    @Autowired PersonRepository personRepository;

    @Autowired
    public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public  int addPerson(Person person){

       return personDAO.insertPerson(person);

    }
    public List<Person> getAllPerson(){
        return  personRepository.findAll();
    }


    public Optional<Person> getSinglePersonByID(String id){
        Long personId=Long.parseLong(id);
        Optional<Person> person= personRepository.findById(personId);
        return  person;
    }

    public Optional<Person> updatePerson(String id, Person person) {
       Person person1= personRepository.findById(Long.parseLong(id)).orElse(null);
        person1.setFirstName(person.getFirstName());
        personRepository.save(person1);
        return  Optional.of(person1);
    }
    public  void deletePerson(String id){
        personRepository.deleteById(Long.parseLong(id));
    }
}
