
import org.application.web.translations.Console;
import de.inetsoftware.jwebassembly.api.annotation.Export;

/**
 * @author felipe
 */
public class Application {

    @Export
    public static void main() {
        try {
            Console.log("Hello World, this text come from WebAssembly.");
        } catch (Exception error) {
            Console.error(error);
        }
    }
}
