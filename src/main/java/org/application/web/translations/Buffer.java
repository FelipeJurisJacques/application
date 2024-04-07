package org.application.web.translations;

import de.inetsoftware.jwebassembly.api.annotation.Import;

/**
 *
 * @author felipe
 */
public class Buffer {

    public int rx() {
        return 0;
    }

    public void tx(String message) {
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int ascii = (int) c;
            Buffer._tx(ascii);
        }
    }

    @Import(module = "window", name = "tx")
    private static native double _tx(int asc);
}
