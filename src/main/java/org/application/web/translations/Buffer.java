package org.application.web.translations;
// import de.inetsoftware.jwebassembly.api.annotation.Export;
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
            Buffer._export(ascii);
        }
    }

    public void document()
    {
        Buffer._document();
    }

    @Import(module = "window", js = "()=>window.document")
    private static native Object _document();

    @Import(module = "window", js = "(value)=>window.buffer = value")
    private static native void _export(int value);

    // @Import(module = "window", name = "tx")
    // private static native double _tx(int asc);
}
