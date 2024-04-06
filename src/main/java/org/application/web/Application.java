import de.inetsoftware.jwebassembly.api.annotation.Export;
// import de.inetsoftware.jwebassembly.web.dom.Document;
// import de.inetsoftware.jwebassembly.web.dom.Window;

/**
 * @author felipe
 */
public class Application {

    @Export
    public static void main() {
        // Document document = Window.document();
        // HTMLElement div = document.createElement("div");
        // Text text = document.createTextNode("Hello World, this text come from WebAssembly."); 
        // div.appendChild( text );
        // document.body().appendChild( div );
    }

    @Export
    public static int add(int[] a) {
        return a[a.length - 1];
    }
}
