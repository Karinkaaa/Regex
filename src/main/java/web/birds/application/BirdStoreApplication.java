package main.java.web.birds.application;

import main.java.web.birds.processor.IInfiniteLoopProcessor;
import main.java.web.birds.processor.UserCommandProcessor;

public class BirdStoreApplication {

    public static void main(String[] args) {

        IInfiniteLoopProcessor userCommandProcessor = new UserCommandProcessor();
        userCommandProcessor.processInLoop();
    }
}
