import org.application.core.Console;
import org.application.web.views.Desktop;
import org.application.core.database.Connection;
import de.inetsoftware.jwebassembly.api.annotation.Export;

/**
 * @author felipe
 */
public class Application {

    @Export
    public static void main() {
        try {
            Connection connection = Connection.getConnection("storage");
            Desktop desktop = new Desktop();
        } catch (Throwable error) {
            Console.error(error);
        }
    }
}
