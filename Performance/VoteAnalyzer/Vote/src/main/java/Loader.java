
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class Loader {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, SQLException {
        String fileName = "res/data-1572M.xml";
        long start = System.currentTimeMillis();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        XMLHandler xmlHandler = new XMLHandler();
        saxParser.parse(new File(fileName), xmlHandler);

        DBConnection.executeMultiInsert();

        System.out.println("Parsing duration: " + (System.currentTimeMillis() - start) + " ms");
        DBConnection.customSelect();
        DBConnection.printVoterCounts();
    }
}
