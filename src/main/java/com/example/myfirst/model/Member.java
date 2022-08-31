package com.example.myfirst.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    public  String firstName;


    public  String middleName;



    public  String lastName;


    public  String gender;


    public Date dateOfBirth;



    public  int father;


    public  int mother;
    public  Date registeredAt;


}
