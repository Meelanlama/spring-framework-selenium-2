package com.milan.api;

import jakarta.validation.Valid;

public class CommunicationDTO {
    private String email;
    @Valid
    private Phone phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
