package org.application.core;

import org.application.core.directrix.Directrix;

/**
 * @author felipe
 */
public class Console extends Directrix {

    public static void log(char value) {
        log(newObject(value));
    }

    public static void log(int value) {
        log(newObject(value));
    }

    public static void log(Object value) {
        setConsoleLog(value);
    }

    public static void log(boolean value) {
        log(newObject(value));
    }

    public static void log(String value) {
        log(newObject(value));
    }

    public static void error(String value) {
        try {
            throw new Exception(value);
        } catch (Throwable error) {
            String origin = "";
            StackTraceElement[] traces = error.getStackTrace();
            for (int i = 0; i < traces.length; i++) {
                StackTraceElement trace = traces[i];
                origin = trace.getFileName();
            }
            setConsoleError(newObject(value), newObject(origin));
        }
    }

    public static void error(Throwable error) {
        String origin = "";
        StackTraceElement[] traces = error.getStackTrace();
        for (int i = 0; i < traces.length; i++) {
            StackTraceElement trace = traces[i];
            origin = trace.getFileName();
        }
        setConsoleError(newObject(error.getMessage()), newObject(origin));
    }
}
