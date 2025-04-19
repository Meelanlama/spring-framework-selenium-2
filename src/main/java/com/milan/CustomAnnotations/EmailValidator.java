package com.milan.CustomAnnotations;

import com.milan.api.RegisterInfoDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmailValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterInfoDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {

        //type casting object to our dto
        RegisterInfoDTO dto = (RegisterInfoDTO) object;

        // Fetch the nested DTO correctly
        if (dto.getCommunicationDTO() == null || dto.getCommunicationDTO().getEmail() == null) {
            errors.rejectValue("communicationDTO.email", "email.required"); // Resolves to email.required message
            return;
        }

        String email = dto.getCommunicationDTO().getEmail();

        if (!email.endsWith("@seleniumexpress.com")) {
            errors.rejectValue("communicationDTO.email", "email.invalidDomain"); // Resolves to email.invalid message
        }
    }
}
