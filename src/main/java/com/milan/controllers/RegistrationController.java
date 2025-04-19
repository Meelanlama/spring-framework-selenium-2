package com.milan.controllers;

import com.milan.CustomAnnotations.EmailValidator;
import com.milan.CustomAnnotations.UserNameValidator;
import com.milan.PropertyEditor.NamePropertyEditor;
import com.milan.api.CommunicationDTO;
import com.milan.api.CreditCard;
import com.milan.api.Phone;
import com.milan.api.RegisterInfoDTO;
import com.milan.formatter.CreditCardFormatter;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @RequestMapping("/register")
    public String showRegisterPage(@ModelAttribute("registerInfo") RegisterInfoDTO registerDto) {

        System.out.println("Inside showRegisterPage method-controller");

        //load the saved user data from the database
//        Phone phone = new Phone();
//        phone.setCountryCode("977");
//        phone.setUserNumber("123456789");
//
//        CommunicationDTO communicationDTO = new CommunicationDTO();
//        communicationDTO.setPhone(phone);
//
//        registerDto.setCommunicationDTO(communicationDTO);


        return "register-page";
    }

    @RequestMapping("/register-success")
    public String showRegisterSuccessPage(@Valid @ModelAttribute("registerInfo") RegisterInfoDTO registerDto, BindingResult result) {

        System.out.println("Name value entered: " + "|" + registerDto.getName() + "|");

        //validating the validator manually
//        EmailValidator emailValidator = new EmailValidator();
//        emailValidator.validate(registerDto, result);

        //if there's error, get all error message
        if (result.hasErrors()) {
            System.out.println("Error in showRegisterSuccessPage");
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error);
            }
            return "register-page";
        }

        System.out.println("Inside showRegisterSuccessPage method-controller");

        //save the dto object into our database

        return "register-success-page";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("Inside initBinder method-controller");

        //Builtin class that can trim the string(name) if it contains white-spaces.
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        //register the class: type, fieldname, trimmeditor obj name;
        binder.registerCustomEditor(String.class, "name", editor);
        //binder.setDisallowedFields("name");

        // for custom Name editor property
        NamePropertyEditor nameEditor = new NamePropertyEditor();
        binder.registerCustomEditor(String.class, "name", nameEditor);

        // Register for validator
        binder.addValidators(new UserNameValidator());
        binder.addValidators(new EmailValidator());

    }
}
