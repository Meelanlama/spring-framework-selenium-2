package com.milan.CustomAnnotations;

import com.milan.api.RegisterInfoDTO;
import com.milan.api.UserInfoDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserNameValidator implements Validator {

    @Override
    //This methods check does the username validator can be applied/supports over a given DTO.
    public boolean supports(Class<?> clazz) {
        // if we get the dto object like this through the supports method,
        // at the time only our validator will be applied to DTO object.
        return RegisterInfoDTO.class.equals(clazz);
    }

    @Override
    // we need to write custom validation logic here
    public void validate(Object object, Errors errors) {

        //to check if userName field is null
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty" ,"User Name cannot empty");

        //Check if String contains _
        //type casting into dto type and getting username
        String userName = ((RegisterInfoDTO) object).getUserName();
        if(!userName.contains("_")){
            errors.rejectValue("userName", "userName.invalid" ,"User Name should contain '_' ");
        }
    }
}
