import org.application.web.translations.Buff;

import de.inetsoftware.jwebassembly.api.annotation.Export;
// import de.inetsoftware.jwebassembly.web.dom.Document;
// import de.inetsoftware.jwebassembly.web.dom.HTMLElement;
// import de.inetsoftware.jwebassembly.web.dom.Text;
// import de.inetsoftware.jwebassembly.web.dom.Window;

/**
 * @author felipe
 */
public class Application {

    @Export
    public static void main() {
        Buff message = new Buff();
        message.tx("Hello World, this text come from WebAssembly.");
        // Window.document();
        // Document document = Window.document();
        // HTMLElement div = document.createElement("div");
        // Text text = document.createTextNode("Hello World, this text come from WebAssembly."); 
        // div.appendChild( text );
        // document.body().appendChild( div );
    }
}
