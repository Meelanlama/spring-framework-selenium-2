package com.milan.controllers;

import com.milan.PropertyEditor.CreditCardEditor;
import com.milan.api.BillDTO;
import com.milan.api.CreditCard;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BillController {

    @RequestMapping("/bill")
    public String bill(@ModelAttribute("billInfo")BillDTO billDTO) {

        //setting default credit card to load in view
        CreditCard creditCard = new CreditCard();
        creditCard.setFirstFourDigits(1234);
        creditCard.setSecondFourDigits(7777);
        creditCard.setThirdFourDigits(9999);
        creditCard.setLastFourDigits(1231);

        billDTO.setCreditCard(creditCard);

        return "bill-page";
    }

    @RequestMapping("/bill-success")
    public String billPage(@ModelAttribute("billInfo") BillDTO billDTO, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors()); // Print errors to console
            return "bill-page";
        }

        System.out.println("Inside bill-success controller");
        System.out.println("Raw Amount String: " + billDTO.getAmountString());
        System.out.println("Parsed Amount: " + (billDTO.getAmount() != null ? billDTO.getAmount().getBillAmount() : "NULL"));
        System.out.println("Currency: " + (billDTO.getAmount() != null ? billDTO.getAmount().getLocaleDefinition() : "NULL"));

        return "bill-success-page";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //for custom date property
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor dateEditor = new CustomDateEditor(format, true);
        binder.registerCustomEditor(Date.class,"date",dateEditor);

        //Adding formatter here instead of config file
        //binder.addCustomFormatter(new CreditCardFormatter());

         //for custom credit card editor property
//        CreditCardEditor creditCardEditor = new CreditCardEditor();
//        binder.registerCustomEditor(CreditCard.class, "creditCard",creditCardEditor);

    }
}
