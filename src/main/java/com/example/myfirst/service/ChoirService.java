package com.example.myfirst.service;

import com.example.myfirst.model.Choir;
import com.example.myfirst.repository.ChoirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoirService {

    @Autowired
    ChoirRepository choirRepository;
    public List<Choir> getAll(){
        return  choirRepository.findAll();
    }
}
