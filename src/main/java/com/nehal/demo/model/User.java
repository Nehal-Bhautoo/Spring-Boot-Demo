package com.nehal.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name="uuid")
    private UUID uuid;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    public User(
            @JsonProperty("uuid") UUID uuid,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }
    public UUID getUuid() {
        return uuid;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
