package com.nehal.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "profile")
public class Profile {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int profile_id;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

    @Column(name = "address")
    private String address;

    @Column(name = "image")
    @Lob
    @Type(type="org.hibernate.type.ImageType")
    private byte[] image;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "userId")
    private int userId;

    public Profile() {}

    public Profile(
            @JsonProperty("email") String email,
            @JsonProperty("phone") int phone,
            @JsonProperty("address") String address,
            @JsonProperty("image") byte[] image,
            @JsonProperty("dateOfBirth") Date dateOfBirth,
            @JsonProperty("userId") int userId
    ) {
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.dateOfBirth = dateOfBirth;
        this.userId = userId;
    }

    public int getProfileId() {
        return profile_id;
    }
    public String getEmail() {
        return email;
    }
    public int getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public byte[] getImage() {
        return image;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public int getUserId() {
        return userId;
    }

    public void setProfileId(int profileId) {
        this.profile_id = profileId;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
