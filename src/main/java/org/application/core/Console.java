package org.application.core;

/**
 *
 * @author felipe
 */
public class Console extends Native {

    public static void log(char value) {
        setConsoleLogChar(value);
    }

    public static void log(int value) {
        setConsoleLogInteger(value);
    }

    public static void log(Object value) {
        setConsoleLogObject(value);
    }

    public static void log(boolean value) {
        setConsoleLogBoolean(value);
    }

    public static void log(String value) {
        setConsoleLogString(value);
    }

    public static void error(String value) {
        setConsoleErrorString(value);
    }

    public static void error(Exception value) {
        setConsoleErrorString(value.getMessage());
    }
}
