//Logging

package com.company;

import java.util.logging.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Logger loggerOne = Logger.getLogger("myFirstLogger");
        Logger loggerTwo = Logger.getLogger("mySecondLogger");
        Logger loggerThree = Logger.getLogger("myThirdLogger");
        Logger loggerFour = Logger.getLogger("myFourthLogger");


        //LoggerOne
        //Get logger name
        System.out.println(loggerOne.getName());
        System.out.println(loggerOne);

        //Log something on console
        loggerOne.log(Level.SEVERE, "This is severe level logger one");
        loggerOne.log(Level.WARNING, "This is warning level logger one");
        loggerOne.log(Level.INFO, "This is info level logger one");
        loggerOne.log(Level.CONFIG, "This is config level logger one");
        loggerOne.log(Level.FINE, "This is fine level logger one");
        loggerOne.log(Level.FINER, "This is finer level logger one");
        loggerOne.log(Level.FINEST, "This is finest level logger one");


        //Logger Two
        //Set log level
        loggerTwo.setLevel(Level.FINER);
        loggerTwo.setUseParentHandlers(false);

        //Console handler
        ConsoleHandler consoleHandlerLoggerTwo = new ConsoleHandler();
        consoleHandlerLoggerTwo.setLevel(Level.ALL);
        loggerTwo.addHandler(consoleHandlerLoggerTwo);

        loggerTwo.log(Level.SEVERE, "This is severe level logger two");
        loggerTwo.log(Level.WARNING, "This is warning level logger two");
        loggerTwo.log(Level.INFO, "This is info level logger two");
        loggerTwo.log(Level.CONFIG, "This is config level logger two");
        loggerTwo.log(Level.FINE, "This is fine level logger two");
        loggerTwo.log(Level.FINER, "This is finer level logger two");
        loggerTwo.log(Level.FINEST, "This is finest level logger two");

        consoleHandlerLoggerTwo.close();


        //Logger Three
        //Set log level
        loggerThree.setLevel(Level.ALL);
        loggerThree.setUseParentHandlers(false);

        //File handler
        //XML-files
        FileHandler fileHandlerLoggerThree = new FileHandler("loggerThree.xml");
        fileHandlerLoggerThree.setFormatter(new XMLFormatter());
        loggerThree.addHandler(fileHandlerLoggerThree);

        //Enter
        loggerThree.entering("Main", "Enter...");

        //Exit
        loggerThree.exiting("Main", "Exit...");

        //Error
        //Like this
        if (1 != 0) {
            IOException ioException = new IOException();
            loggerThree.throwing("Main", "Something went wrong, we got error here", ioException);
        }

        fileHandlerLoggerThree.close();


        //Logger Four
        //Set log level
        loggerFour.setLevel(Level.ALL);
        loggerFour.setUseParentHandlers(false);

        //File handler
        //XML-files
        FileHandler fileHandlerLoggerFour = new FileHandler("loggerFour.log");
        loggerFour.addHandler(fileHandlerLoggerFour);
        fileHandlerLoggerFour.setFormatter(new SimpleFormatter());

        //Some message
        loggerFour.log(Level.SEVERE, "Severe level");
        loggerFour.log(Level.WARNING, "Warning level");
        loggerFour.log(Level.INFO, "Info level");
        loggerFour.log(Level.CONFIG, "Config level");
        loggerFour.fine("Fine level");
        loggerFour.finer("Finer level");
        loggerFour.finest("Finest level");

        fileHandlerLoggerFour.close();
    }
}
