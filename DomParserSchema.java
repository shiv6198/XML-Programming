import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.XMLConstants;

public class DomParserSchema {

    public static void main(String[] args) {
        try {
            File schemaFile = new File("bookstoreschem.xsd");
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(schemaFile);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setSchema(schema);
            DocumentBuilder db = dbf.newDocumentBuilder();
            db.parse(new File("bookstore.xml"));
            System.out.println("the file is valid");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

}