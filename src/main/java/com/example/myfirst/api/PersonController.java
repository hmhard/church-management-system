package com.example.myfirst.api;

import com.example.myfirst.dao.PersonRepository;
import com.example.myfirst.model.Person;
import com.example.myfirst.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {


    @Autowired
    PersonRepository personRepository;
    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public  void addPerson(@RequestBody Person person){
        personRepository.save(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
       return  personService.getAllPerson();
    }
    @GetMapping("{id}")
    public Optional<Person> show(@PathVariable String id){
      return  personService.getSinglePersonByID(id);
    }
    @PutMapping("{id}")
    public Optional<Person> update(@PathVariable String id,Person person){
        return  personService.updatePerson(id,person);
    }

    @DeleteMapping("{id}")
    public  String delete(@PathVariable String id){
        personService.deletePerson(id);
        return  "deleted successfully";
    }

}
