package main.java.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("main")
public class MainController {

    static Logger logger = LoggerFactory.getLogger("main.controller");

    public MainController() {
        logger.info("Controller created...");
    }

    @RequestMapping("get-some-data")
    @ResponseBody
    public String[] getSomeData() {
        logger.info("Controller method invoked...");
        return new String[]{"1", "22", "333"};
    }

    public static void main(String[] args) {

        logger.error("Main method invoked...");
    }
}
