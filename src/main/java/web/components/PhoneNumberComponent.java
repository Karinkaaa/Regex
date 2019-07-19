package main.java.web.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PhoneNumberComponent {

    //private final String PHONE_PATTERN = "^(?<country>\\+[1-9]{1,2})(?<operator>[0-9]{3})(?<localNumber>[0-9]{7})$";

    @Value("${regex.phone-number-pattern}")
    private String phoneNumberPattern;

    @PostConstruct
    public void propertiesDefined() {
        System.out.println("phoneNumberPattern is " + phoneNumberPattern);
    }

    public Map<String, String> parsePhoneNumber(String phone) {

        Pattern pattern = Pattern.compile(phoneNumberPattern);
        Matcher matcher = pattern.matcher(phone);

        System.out.println("Pattern: " + phoneNumberPattern);
        System.out.println("Phone: |" + phone + "|");

        if (!matcher.matches()) {
            System.out.println("Matcher not matches...");
            return Collections.emptyMap();
        } else {
            Map<String, String> result = new HashMap<>();
            result.put("country", matcher.group("country"));
            result.put("operator", matcher.group("operator"));
            result.put("localNumber", matcher.group("localNumber"));
            return result;
        }
    }
}
