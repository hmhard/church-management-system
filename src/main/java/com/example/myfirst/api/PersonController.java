package com.example.myfirst.api;

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


    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public  void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return  personService.getAllPerson();
    }
    @GetMapping(path = "{id}")
    public Optional<Person> getSinglePersonByID(@PathVariable("id") UUID id){
        return Optional.ofNullable(personService.getSinglePersonByID(id));
    }

}
