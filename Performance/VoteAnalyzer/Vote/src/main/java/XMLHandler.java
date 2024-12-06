import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler {

    private static final SimpleDateFormat VISIT_DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private static final HashMap<Integer, WorkTime> VOTE_STATION_WORK_TIMES = new HashMap<>();

    // флаги
    private boolean isVoterElement = false;
    private boolean isVisitElement = false;


    private String currentVoterName;
    private String currentVoterBirthDay;
    private Integer currentVoteStation;
    private Date currentVisitTime;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "voter":
                isVoterElement = true;
                currentVoterName = attributes.getValue("name");
                currentVoterBirthDay = attributes.getValue("birthDay");
                break;
            case "visit":
                isVisitElement = true;
                try {
                    currentVoteStation = Integer.parseInt(attributes.getValue("station"));
                    currentVisitTime = VISIT_DATE_FORMAT.parse(attributes.getValue("time"));
                } catch (ParseException e) {
                    throw new SAXException(e);
                }
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "voter":
                isVoterElement = false;
                try {
                    DBConnection.countVoter(currentVoterName, currentVoterBirthDay);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "visit":
                isVisitElement = false;
                WorkTime workTime = VOTE_STATION_WORK_TIMES.computeIfAbsent(currentVoteStation, k -> new WorkTime());
                workTime.addVisitTime(currentVisitTime.getTime());
                break;
        }
    }
}
