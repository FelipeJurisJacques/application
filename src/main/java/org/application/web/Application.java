import org.application.web.libs.Console;
import org.application.web.views.Desktop;
import de.inetsoftware.jwebassembly.api.annotation.Export;

/**
 * @author felipe
 */
public class Application {

    @Export
    public static void main() {
        try {
            Desktop desktop = new Desktop();
        } catch (Exception error) {
            Console.error(error);
        }
    }
}
