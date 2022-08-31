package com.example.myfirst.repository;

import com.example.myfirst.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PersonRepository extends JpaRepository<Person,Long> {



}
