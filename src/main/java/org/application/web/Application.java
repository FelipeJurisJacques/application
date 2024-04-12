import org.application.web.libs.Console;
import org.application.web.widgets.Widget;
import org.application.web.elements.Document;
import de.inetsoftware.jwebassembly.api.annotation.Export;

/**
 * @author felipe
 */
public class Application {

    @Export
    public static void main() {
        try {
            Document.getBody().setAppend(Widget.create('p')
                    .setContent("Hello World, this text come from WebAssembly.")
                    .setAttribute("class", "test"));
        } catch (Exception error) {
            Console.error(error);
        }
    }
}
