import org.application.core.Console;
import org.application.core.Location;
import org.application.web.views.Desktop;
import org.application.web.views.Curriculum;
import org.application.core.elements.Document;
import org.application.core.elements.html.Head;
import de.inetsoftware.jwebassembly.api.annotation.Export;

/**
 * @author Felipe Juris Jacques
 */
public class Application {

    @Export
    public static void main() {
        try {
            String path = Location.path();
            Document document = Document.getInstance();
            if (path.equals("/")) {
                Head head = document.getHead();
                head.addManifest("/source/assets/manifest.json");
                Desktop desktop = new Desktop(document);
            } else if (path.equals("/navigation/curriculum/")) {
                Curriculum curriculum = new Curriculum(document.getBody());
            }
        } catch (Throwable error) {
            Console.error(error);
        }
    }
}
