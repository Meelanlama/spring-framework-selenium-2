package com.milan.model_attribute_method_level;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//now, this class model object data will be only available here
@ControllerAdvice(assignableTypes = TestController.class)
public class MyWebsiteController {

    @ModelAttribute("websiteInfo")
    public WebsiteInfoDTO getWebsiteInfo() {

        System.out.println("***************");
        System.out.println("@ModelAttribute: Inside getWebsiteInfo");

        WebsiteInfoDTO websiteInfoDTO = new WebsiteInfoDTO();

        websiteInfoDTO.setWebsiteName("Udemy.com");
        websiteInfoDTO.setWebsiteCategory("Education");

        System.out.println("***************");

        return websiteInfoDTO;
    }

    @ModelAttribute("header123")
    public String getWebsiteHeader() {
        System.out.println("Inside @ModelAttribute: getWebsiteHeader");
        return "Udemy";
    }

    // will get the object back from the model attribute method if it's available and inserted to dto
    //The object of @ModelAttribute method will inject to dto reference
    @RequestMapping("/showInfo")
    public String showWebsiteInfo(@ModelAttribute("websiteInfo") WebsiteInfoDTO websiteDTO) {
        System.out.println("@RequestMapping: showWebsiteInfo");

        System.out.println(websiteDTO.getWebsiteName());
        System.out.println(websiteDTO.getWebsiteCategory());

        return "index-website";
    }

    @RequestMapping("/showHeader")
    public String showWebsiteHeader(@ModelAttribute("header123") String header) {

        System.out.println("@RequestMapping: insideHeader()");

        System.out.println(header);
        return "index-website";
    }

}
