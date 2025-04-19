package com.milan.model_attribute_method_level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class TestController {

    @Autowired
    Info info;

    @RequestMapping("/testing")
    public String test(@ModelAttribute("websiteInfo") WebsiteInfoDTO webDto) {
        System.out.println(webDto.getWebsiteName());
        System.out.println(webDto.getWebsiteCategory());

        System.out.println("Ip address of server is: " + info.getServerIp());

        //throwing exceptions and our handler method will handle this
        if (1 == 1) {
            throw new RuntimeException();
        }

        return "index-website";
    }
    
}
