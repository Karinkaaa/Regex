package main.java.web.controller;

import main.java.web.exceptions.ApplicationLogicException;
import main.java.web.exceptions.BaseResponse;
import main.java.web.exceptions.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("main")
public class MainController {

    static Logger logger = LoggerFactory.getLogger("main.controller");

    public MainController() {
        logger.info("Controller created...");
    }


    @RequestMapping(value = {"/main/get-some-data", "/"}, method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse<String[]> getSomeData(Integer param1, Double param2, String param3)
            throws ApplicationLogicException, RuntimeException {

        logger.info("Controller method invoked...");

        if (param1 == null) {
            throw new ApplicationLogicException("Param <param1> is null!");
        } else if (param2 == null) {
            throw new RuntimeException("Param <param2> is null!");
        }

        SuccessResponse<String []> response = new SuccessResponse<>();
        response.setData(new String[]{"1", "22", "333"});
        return response;
    }

    @ExceptionHandler(ApplicationLogicException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleApplicationLogicException(ApplicationLogicException e) {
        return "Some error happens...";
    }

    public static void main(String[] args) {

        logger.error("Main method invoked...");
    }
}
