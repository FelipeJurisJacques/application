package org.application.core;

import org.application.core.directrix.Directrix;

/**
 *
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
        setConsoleError(newObject(value));
    }

    public static void error(Throwable value) {
        error(value.getMessage());
    }
}
