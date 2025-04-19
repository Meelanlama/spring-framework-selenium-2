package com.milan.controllers;

import com.milan.api.RegisterInfoDTO;
import com.milan.api.UserInfoDTO;
import com.milan.service.LcAppServiceImpl;
import jakarta.servlet.http.*;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userInfo")
public class LCAppController {

    @Autowired
    private LcAppServiceImpl LcAppService;

    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("userInfo", new UserInfoDTO());
        return "home-page";
    }

    @RequestMapping("/process-homepage")
    public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO, BindingResult result) {
        System.out.println(userInfoDTO.isTermsAndConditions());

        //checks if there's any error if error then return homepage view
        if (result.hasErrors()) {
            return "home-page";
        }

        // creating session which will manage cookie behind the scene

        //Write a service call which will calculate what love between user and crush
        String loveResult = LcAppService.calculateLove(userInfoDTO.getUserName(), userInfoDTO.getCrushName());
        userInfoDTO.setResult(loveResult);

        return "result-page";
    }
}
