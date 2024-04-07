package org.application.web.translations;

import de.inetsoftware.jwebassembly.api.annotation.Import;

/**
 *
 * @author felipe
 */
public class Console {

    public static void log(String value) {
        Console._log(Console.stringToAscII(value));
    }

    public static void error(String value) {
        Console._error(Console.stringToAscII(value));
    }

    public static void error(Exception value) {
        Console._error(Console.stringToAscII(value.getMessage()));
    }

    protected static int[] stringToAscII(String value) {
        int[] result = new int[value.length()];
        for (int i = 0; i < value.length(); i++) {
            result[i] = (int) value.charAt(i);
        }
        return result;
    }

    @Import(module = "console", js = "(v) => { const l = []; for (let i of v[2]) { l.push(String.fromCharCode(i)); } console.log(l.join('')); }")
    private static native void _log(int[] value);

    @Import(module = "console", js = "(v) => { const l = []; for (let i of v[2]) { l.push(String.fromCharCode(i)); } console.error(l.join('')); }")
    private static native void _error(int[] value);
}
