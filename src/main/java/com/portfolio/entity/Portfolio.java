package com.portfolio.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="portfolio")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="id", nullable = false, unique = true)
    private Long id;

    @Column
    private String experience;

    @Column
    private String imagePath;

    @Column
    private String name;

    @Column
    private String twitterUser;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String zipCode;

    public Portfolio() {
    }

    public Portfolio(String experience, String imagePath, String name, String twitterUser, String email, String address, String phone, String zipCode) {
        this.experience = experience;
        this.imagePath = imagePath;
        this.name = name;
        this.twitterUser = twitterUser;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperiencie(String experiencie) {
        this.experience = experiencie;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTwitterUser() {
        return twitterUser;
    }

    public void setTwitterUser(String twitterUser) {
        this.twitterUser = twitterUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", experiencie='" + experience + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", name='" + name + '\'' +
                ", twitterUser='" + twitterUser + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
