package main.java.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("main")
public class MainController {

    static Logger logger = LoggerFactory.getLogger("main.controller");

    public MainController() {
        logger.info("Controller created...");
    }

    @RequestMapping(value = "get-some-data", method = RequestMethod.POST)
    @ResponseBody
    public String[] getSomeData(int param1, double param2, String param3) {
        logger.info("Controller method invoked...");
        return new String[]{"1", "22", "333"};
    }

    public static void main(String[] args) {

        logger.error("Main method invoked...");
    }
}
