package com.notefy.notefyapp.logger;

import java.util.Date;

public class    Logger {
    private static Logger instance;
    private int counter = 0;

    // Private constructor to prevent instantiation outside the class
    private Logger() {

    }

    // Public method to get the singleton instance
    public static Logger getInstance() {
        synchronized (Logger.class) {
            if (instance == null) {
                    instance = new Logger();
            }
        }
        return instance;
    }

    // Method to log messages
    public void info(String message) {
        log(message, LogType.INFO);
    }

    public void log(String message, LogType logType) {
        counter += 1;
        Date currentDateTime = new Date();
        System.out.println(
                "ID:" + counter + "; " +
                "Message:\"" + message + "\"; " +
                "Date:" + currentDateTime + "; " +
                "Type:" + logType.toString() + ";"
        );
    }
}
