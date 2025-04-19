package com.milan.sessionattribute;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class SecondController {

    @RequestMapping("/anotherMethod")
    public String handleMethod3(Model model, HttpSession session) {
        // String firstName = (String) model.getAttribute("firstName");

        //fetching from the session and doing some changes and adding in model.
        String address = (String) session.getAttribute("address");
        String newAddress = address + ",Bhumisthali,Gokarneshowr-2";
        model.addAttribute("address", newAddress);

        session.invalidate(); //removing

        return "index-session";
    }
}
