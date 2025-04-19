package com.milan.api;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInfoDTO {

    @NotBlank(message = "{String.notEmpty}")
    @Size(min = 3, max = 15, message = "{invalidMessage}")
    private String userName;

    @NotBlank(message = "{String.notEmpty}")
    @Size(min = 3, max = 15, message = "{invalidMessage}")
    private String crushName;

    private String result;
    
    @AssertTrue(message = "{termsAndConditionsMessage}")
    private boolean termsAndConditions;

    public boolean isTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(boolean termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCrushName() {
        return crushName;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "userName='" + userName + '\'' +
                ", crushName='" + crushName + '\'' +
                '}';
    }
}
