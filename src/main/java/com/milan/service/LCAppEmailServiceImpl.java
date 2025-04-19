package com.milan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {

    //FETCHING THE OBJECT OF MAIL SENDER FROM CONFIG CLASS
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String userName, String userEmail, String result) {
        //create email
        SimpleMailMessage newEmail = new SimpleMailMessage();
        newEmail.setTo(userEmail); //user-email
        newEmail.setSubject("Love Calculator Application Result"); // email subject
        newEmail.setText("Hi " + userName + "!  The result predicted by love calculator is " + result);

        mailSender.send(newEmail);

    }
}
