package main.java.web.controller;

import main.java.birds.my_exceptions.DeletingNonexistentObjectException;
import main.java.birds.my_exceptions.ExistingIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {

    Logger logger = LoggerFactory.getLogger("my-exception-handler");

    @ExceptionHandler(DeletingNonexistentObjectException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handlerDeletingNonexistentObjectException(DeletingNonexistentObjectException e) {

        logger.error(e.getMessage());
        return "Deleting Nonexistent Object Exception occurred...";
    }

    @ExceptionHandler(ExistingIdException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handlerExistingIdException(ExistingIdException e) {

        logger.error(e.getMessage());
        return "Existing Id Exception occurred...";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handlerException(Exception e) {

        logger.error(e.getMessage());
        return "Some Exception occurred...";
    }
}
