package main.java.birds.application;

import main.java.web.processor.IInfiniteLoopProcessor;
import main.java.web.processor.UserCommandProcessor;

public class BirdStoreApplication {

    public static void main(String[] args) {

        IInfiniteLoopProcessor userCommandProcessor = new UserCommandProcessor();
        userCommandProcessor.processInLoop();
    }
}
