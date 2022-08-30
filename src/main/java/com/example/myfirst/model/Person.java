package com.example.myfirst.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    UUID id;
    String firstName;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("firstName") String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
}
