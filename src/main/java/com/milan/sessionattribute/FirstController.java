package com.milan.sessionattribute;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes({"firstName", "lastName"})
@Controller
public class FirstController {

    @RequestMapping("/first")
    public String handleMethod1(Model model, HttpServletRequest request) {
        model.addAttribute("firstName", "Milan");
        model.addAttribute("lastName", "Tamang");

        model.addAttribute("next", "second");

        HttpSession session = request.getSession();
        session.setAttribute("address", "Kathmandu");

        return "index-session";
    }

    @RequestMapping("/second")
    public String handleMethod2(Model model1) {

        //Trying to fetch data from the /first controller, will get from request scope first if present then only session
        String firstName = (String) model1.getAttribute("firstName");
        System.out.println(firstName);

        String lastName = (String) model1.getAttribute("lastName");
        System.out.println(lastName);

        model1.addAttribute("next", "third");

        return "index-session";
    }

    @RequestMapping("/third")
    public String handleMethod3(Model model2, HttpSession session, SessionStatus sessionStatus) {

        String lastName = (String) model2.getAttribute("lastName");
        System.out.println("Third request: Fetching from model: " + lastName);

        model2.addAttribute("next", "anotherMethod");

        //removing the session attributes from the session scope
        sessionStatus.setComplete();

        //fetching from the session and doing some changes and adding in model.
        String address = (String) session.getAttribute("address");
        String newAddress = address + ",Gokarneshowr-2";
        model2.addAttribute("address", newAddress);

        return "index-session";
    }
}

