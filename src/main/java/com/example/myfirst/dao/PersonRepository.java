package com.example.myfirst.dao;

import com.example.myfirst.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface  PersonRepository extends JpaRepository<Person,Long> {



}
