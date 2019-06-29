package main.java.logback;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {

        /*
        int count = 0;

        final Logger logger = (Logger) LoggerFactory.getLogger("main.java.logback");
        logger.debug("Hi there!");

        Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.debug("This message is logged because DEBUG == DEBUG.");

        rootLogger.setLevel(Level.ERROR);

        logger.warn("This message is not logged because WARN < ERROR.");
        logger.error("This is logged.");
        */

        /*
        String message = "This is String!";
        Integer zero = 0;

        try {
            logger.debug("Logging message: {}", message);
            logger.debug("Going to divide {} by {}", 42, zero);
            int res = 42 / zero;
        } catch (Exception e) {
            logger.error("Error dividing {} by {}", 42, zero, e);
        }
        */

        Logger foobar = (Logger) LoggerFactory.getLogger("com.building.foobar");
        Logger logger = (Logger) LoggerFactory.getLogger("com.building.logback");
        Logger testsLogger = (Logger) LoggerFactory.getLogger("com.building.logback.tests");

        foobar.debug("This is logged from foobar");
        logger.debug("This is not logged from logger");
        logger.info("This is logged from logger");
        testsLogger.info("This is not logged from tests");
        testsLogger.warn("This is logged from tests");

    }
}
