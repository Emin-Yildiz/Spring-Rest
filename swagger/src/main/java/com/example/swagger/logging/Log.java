package com.example.swagger.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    private static final Logger Log = LoggerFactory.getLogger(Log.class);

    public static void info (String message) {
        Log.info(message);
    }

    public static void trace (String message) {
        Log.trace(message);
    }
    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }
    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
    }
    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }

}
