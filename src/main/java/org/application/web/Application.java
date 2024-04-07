import org.application.web.translations.Console;
import de.inetsoftware.jwebassembly.api.annotation.Import;
import de.inetsoftware.jwebassembly.api.annotation.Export;

/**
 * @author felipe
 */
public class Application {

    @Export
    public static void main() {
        try {
            Console.log("Hello World, this text come from WebAssembly.");
            Object document = Application._document();
        } catch (Exception error) {
            Console.error(error);
        }
    }

    
    @Import(module = "window", js = "() => { return window.document }")
    private static native Object _document();
}
