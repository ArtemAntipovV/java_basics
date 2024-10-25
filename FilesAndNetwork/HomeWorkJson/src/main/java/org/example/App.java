package org.example;



import org.example.findFiles.FindFiles;
import org.example.jsonFileCreator.Line;
import org.example.jsonFileCreator.StantionIndex;
import org.example.jsonFileCreator.Station;
import org.example.parseFiles.ParseJson;
import org.example.parseFiles.parseCvs.ParseCsv;
import org.example.parseJsoup.ParseJsoup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.List;

public class App {

    private static StantionIndex stationIndex;
    private final static String PATH_STATION_DATA = "data/stations-data";
    private final static String PATH = "data/fileHtml/MskMetro.html";
    private static final String FILE_METRO = "data/json//MetroStations.json";
    private static final String FILE_STATIONS = "data/json//fileStationsSbp.json";
    private final static String PATH_DATES_1 = "data/stations-data/dates-1.csv";
    private final static String PATH_DATES_2 = "data/stations-data/dates-2.csv";
    private final static String PATH_DATES_3 = "data/stations-data/dates-3.csv";
    private final static String PATH_DEPTHS_1 = "data/stations-data/depths-1.json";
    private final static String PATH_DEPTHS_2 = "data/stations-data/depths-2.json";
    private final static String PATH_DEPTHS_3 = "data/stations-data/depths-3.json";


    public static void main(String[] args) {
        start();
        createJsonMetro();
        createJsonStations();
        getSearchFiles();
    }

    private static void start() {


        // парсинг CSV
        ParseCsv parseCSV = new ParseCsv();
        parseCSV.parcingCsvFiles(PATH_DATES_1);
        parseCSV.parcingCsvFiles(PATH_DATES_2);
        parseCSV.parcingCsvFiles(PATH_DATES_3);

        // парсинг JSON
        ParseJson parseJson = new ParseJson();
        parseJson.parcingJsonFiles(PATH_DEPTHS_1);
        parseJson.parcingJsonFiles(PATH_DEPTHS_2);
        parseJson.parcingJsonFiles(PATH_DEPTHS_3);

//         парсинг html
        ParseJsoup parseJsoup = new ParseJsoup(PATH);
        stationIndex = new StantionIndex(parseJsoup, parseCSV, parseJson);
    }

    //  файл stations.json со свойствами станций.
    public static void createJsonStations() {
        JSONArray jsonArray = new JSONArray();
        for (Station st : stationIndex.getStations()) {
            JSONObject jsonObject = new JSONObject();
            if (st.getNameStation() != null) {
                jsonObject.put("name", st.getNameStation());
            }
            if (st.getNameLine() != null) {
                jsonObject.put("line", st.getNameLine());
            }
            if (st.getDate() != null) {
                jsonObject.put("date", st.getDate());
            }
            if (st.getDepthStation() != null) {
                jsonObject.put("depth", st.getDepthStation());
            }
            jsonObject.put("hasConnection", st.isHasConnection());
            jsonArray.add(jsonObject);
        }
        JSONObject jsonStation = new JSONObject();
        jsonStation.put("stations", jsonArray);
//        System.out.println(jsonStation);
        try {
            FileWriter writer = new FileWriter(FILE_STATIONS);
            writer.write(jsonStation.toJSONString());
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // файл со списком станций по линиям и списком линий по формату JSON-файла из проекта SPBMetro.
    private static void createJsonMetro() {
        JSONObject stationObject2 = new JSONObject();
        JSONArray lineArray = new JSONArray();
        for (Line ln : stationIndex.getLines()) {
            stationObject2.put(ln.getNumberLine(), ln.getStations());
        }
        for (Line ln2 : stationIndex.getLines()) {
            JSONObject lineObject2 = new JSONObject();
            lineObject2.put("number", ln2.getNumberLine());
            lineObject2.put("name", ln2.getNameLine());
            lineArray.add(lineObject2);
        }
        JSONObject jsonStation2 = new JSONObject();
        jsonStation2.put("stations", stationObject2);
        jsonStation2.put("lines", lineArray);
        System.out.println(jsonStation2);
        try {
            FileWriter writer2 = new FileWriter(FILE_METRO);
            writer2.write(jsonStation2.toJSONString());
            writer2.flush();
            writer2.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // поиск файлов в папках. В методах этого класса необходимо реализовать обход папок, лежащих в архиве.
    private static void getSearchFiles() {
        FindFiles findFiles = new FindFiles();
        String[] extensions = {"json", "csv"};
        List<String> files = findFiles.findFiles(Paths.get(PATH_STATION_DATA), extensions);
        files.forEach(System.out::println);


    }
}
