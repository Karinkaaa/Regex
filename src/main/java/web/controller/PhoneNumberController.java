package main.java.web.controller;

import main.java.web.components.PhoneNumberComponent;
import main.java.web.exceptions.BaseResponse;
import main.java.web.exceptions.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PhoneNumberController {

    @Autowired
    private PhoneNumberComponent component;

    @RequestMapping("validate-phone")
    @ResponseBody
    public BaseResponse<Map<String, String>> parsePhoneNumber(String phoneNumber) {

        SuccessResponse<Map<String, String>> response = new SuccessResponse<>();
        response.setData(component.parsePhoneNumber(phoneNumber));
        return response;
    }
}
