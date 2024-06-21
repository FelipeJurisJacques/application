import org.application.core.Console;
import org.application.core.http.Client;
import org.application.core.http.Request;
import org.application.web.views.Desktop;
import org.application.core.http.Response;
import org.application.core.directrix.Property;
import org.application.core.directrix.Directrix;
import org.application.core.asynchronous.Promise;
import org.application.core.asynchronous.ActionThen;
import de.inetsoftware.jwebassembly.api.annotation.Export;

/**
 * @author felipe
 */
public class Application {

    @Export
    public static void main() {
        try {
            Desktop desktop = new Desktop();
        } catch (Throwable error) {
            Console.error(error);
        }
    }
}
