package org.example;

import org.example.stringutils.StringProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Program started");
        
        readBuildInfo();
        
        System.out.print("Write a line: ");
        
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String result = StringProcessor.reverseAndCapitalize(input);    

        logger.info("Reversed and capitalized: {}", result);
        logger.info("Program stopped");
    }
    
    private static void readBuildInfo() {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("build-passport.properties")) {
            if (input == null) {
                logger.warn("Could not find build-passport.properties");
                return;
            }
            
            Properties prop = new Properties();
            prop.load(input);
            
            logger.info("BUILD INFORMATION");
            logger.info("Build #: {}", prop.getProperty("build.number", "N/A"));
            logger.info("Git commit: {}", prop.getProperty("git.commit", "N/A"));
            logger.info("User: {}", prop.getProperty("user", "N/A"));
            logger.info("OS: {}", prop.getProperty("os", "N/A"));
            logger.info("Java version: {}", prop.getProperty("java_version", "N/A"));
            logger.info("Build date: {}", prop.getProperty("build_date", "N/A"));
            logger.info("Message: {}", prop.getProperty("message", "N/A"));
        } catch (Exception e) {
            logger.error("Error reading build info", e);
        }
    }
}