package com.example.myfirst.repository;

import com.example.myfirst.model.Choir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoirRepository extends JpaRepository<Choir ,Long> {
}
