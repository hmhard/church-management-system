package com.example.myfirst.service;

import com.example.myfirst.model.Choir;
import com.example.myfirst.repository.ChoirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ChoirService {

    @Autowired
    ChoirRepository choirRepository;
    public List<Choir> getAll(){
        return  choirRepository.findAll();
    }

    public Choir addChoir(Choir choir) {
        choir.setRegisteredAt(new Date());
        return choirRepository.save(choir);
    }
    public Optional<Choir> getChoir(String id){
        Choir choir= choirRepository.findById(Long.parseLong(id)).get();
   return  Optional.of(choir);
    }
    public Choir updateChoir(String id, Choir choir) {
        Choir existingChoir=choirRepository.getById(Long.parseLong(id));
        if(Objects.nonNull(existingChoir)){
            existingChoir.setName(choir.getName());
        existingChoir.setRegisteredAt(new Date());
        }
        return choirRepository.save(existingChoir);
    }
    public  String deleteChoir(String id){

        Choir choir=choirRepository.findById(Long.parseLong(id)).orElse(null);
        if(Objects.nonNull(choir))
        choirRepository.delete(choir);

        return  "Deleted successfully";
    }

}
