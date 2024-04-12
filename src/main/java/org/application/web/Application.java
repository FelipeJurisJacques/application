import org.application.web.libs.Console;
import org.application.web.elements.Body;
import org.application.web.elements.Document;
import org.application.web.elements.Paragraph;
import de.inetsoftware.jwebassembly.api.annotation.Export;

/**
 * @author felipe
 */
public class Application {

    @Export
    public static void main() {
        try {
            Console.log("Hello World, this text come from WebAssembly.");
            Paragraph p = new Paragraph();
            p.setContent("Test");
            p.setAttribute("class", "test");
            Body body = Document.getBody();
            body.setAppend(p);
            // p.getAttribute("class");
            // StringBuilder test = new StringBuilder();
            // test.append("testando");
            // test.append(" o teste");
            String test = "testando";
            test += " o teste";
            // String test = tes + part;
            Console.log(test);
        } catch (Exception error) {
            Console.error(error);
        }
    }
}
