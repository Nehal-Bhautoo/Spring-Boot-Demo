package com.nehal.demo.model;

import java.util.UUID;

public class User {

    private final UUID id;
    private final String firstName;
    private final String lastName;

    public User(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}
