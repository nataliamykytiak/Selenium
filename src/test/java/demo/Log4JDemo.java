package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Natalia Mykytiak
 */
public class Log4JDemo {

    private static Logger logger = LogManager.getLogger(Log4JDemo.class);

    public static void main(String[] args) {
        System.out.println("Hello World");

        logger.trace("This is trace message");
        logger.info("This is information message");
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.fatal("This is a fatal message");

        System.out.println("Completed");

    }
}
