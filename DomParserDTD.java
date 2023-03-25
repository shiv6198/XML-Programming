import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

public class DomParserDTD {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(new EntityResolver() {
                @Override
                public InputSource resolveEntity(String publicId, String systemId) {
                    if (systemId.endsWith("bookstore.dtd")) {
                        return new InputSource("bookstore.dtd");
                    }
                    return null;
                }
            });
            builder.parse(new File("bookstore.xml"));
            System.out.println("the file is valid");

        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

}