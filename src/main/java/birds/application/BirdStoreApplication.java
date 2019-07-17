package main.java.birds.application;

import main.java.birds.my_exceptions.DeletingNonexistentObjectException;
import main.java.birds.my_exceptions.ExistingIdException;
import main.java.birds.my_exceptions.InvalidDataException;
import main.java.web.processor.IInfiniteLoopProcessor;
import main.java.web.processor.UserCommandProcessor;

public class BirdStoreApplication {

    public static void main(String[] args)
            throws ExistingIdException, DeletingNonexistentObjectException, InvalidDataException {

        IInfiniteLoopProcessor userCommandProcessor = new UserCommandProcessor();
        userCommandProcessor.processInLoop();
    }
}
