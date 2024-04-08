package org.application.web.libs;

/**
 *
 * @author felipe
 */
public class Console extends Native {

    public static void log(int value) {
        Console.logInteger(value);
    }

    public static void log(Object value) {
        Console.logObject(value);
    }

    public static void log(boolean value) {
        Console.logBoolean(value ? 1 : 0);
    }

    public static void log(String value) {
        Console.logString(Console.stringToAscii(value));
    }

    public static void error(String value) {
        Console.errorString(Console.stringToAscii(value));
    }

    public static void error(Exception value) {
        Console.errorString(Console.stringToAscii(value.getMessage()));
    }
}
