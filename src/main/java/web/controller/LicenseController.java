package main.java.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class LicenseController {

    @RequestMapping("license")
    public void getLicenseFile(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/plain");
        response.setStatus(200);    // Status 200: server lock response

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                LicenseController.class.getClassLoader().getResourceAsStream("license.txt"), "UTF-8"))) {

            String str;
            while ((str = br.readLine()) != null) {
                response.getOutputStream().println(str);
            }
        }
    }
}
