package com.milan.api;

import com.milan.CustomAnnotations.Age;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class RegisterInfoDTO {

    @NotEmpty(message = "{String.notEmpty}")
    private String name;
    private String userName;
    private char[] password;
    private String country;
    private String[] hobbies;  // using an array for multiple hobbies
    private String gender;
    @Valid
    private CommunicationDTO communicationDTO;

    @Age(lower = 21, upper = 48)
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public CommunicationDTO getCommunicationDTO() {
        return communicationDTO;
    }

    public void setCommunicationDTO(CommunicationDTO communicationDTO) {
        this.communicationDTO = communicationDTO;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
