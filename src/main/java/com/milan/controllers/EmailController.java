package com.milan.controllers;

import com.milan.api.EmailDTO;
import com.milan.api.UserInfoDTO;
import com.milan.config.LoveCalculatorAppConfig;
import com.milan.service.LCAppEmailService;
import com.milan.service.LCAppEmailServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class EmailController {

    Logger logger = Logger.getLogger(EmailController.class.getName());

    @Autowired
    private LCAppEmailService lcAppEmailService;

    @RequestMapping("/sendEmail")
    public String sendEmail(@ModelAttribute("emailDto") EmailDTO emailDto) {

        return "send-email-page";
    }

    @RequestMapping("/process-email")
    public String processEmail(@SessionAttribute("userInfo") UserInfoDTO userInfoDTO,
                               @ModelAttribute("emailDto") EmailDTO emailDTO) {

        //calling the method of service class
        try {
            lcAppEmailService.sendEmail(userInfoDTO.getUserName(), emailDTO.getUserEmail(), userInfoDTO.getResult());
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return "process-email-page";
    }
}
