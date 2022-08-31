package com.example.myfirst.controller;

import com.example.myfirst.model.Choir;
import com.example.myfirst.service.ChoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/choir")
public class ChoirController {


    @Autowired
    ChoirService choirService;

    @GetMapping
    public List<Choir> getAll(){
        return choirService.getAll();
    }


}
