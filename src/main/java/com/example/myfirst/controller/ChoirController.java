package com.example.myfirst.controller;

import com.example.myfirst.model.Choir;
import com.example.myfirst.service.ChoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/choir")
public class ChoirController {


    @Autowired
    ChoirService choirService;

    @GetMapping
    public List<Choir> getAll(){
        return choirService.getAll();
    }
    @GetMapping("{id}")
    public Optional<Choir> getChoir(@PathVariable String id){
        return choirService.getChoir(id);
    }

    @PostMapping
    public  Choir addChoir(@RequestBody Choir choir){
        return choirService.addChoir(choir);
    }
    @PutMapping("{id}")
    public  Choir updateChoir(@PathVariable String id, @RequestBody Choir choir){
        return choirService.updateChoir(id,choir);
    }
    @DeleteMapping("{id}")
    public  String delete(@PathVariable String id){
        return  choirService.deleteChoir(id);
    }

}
