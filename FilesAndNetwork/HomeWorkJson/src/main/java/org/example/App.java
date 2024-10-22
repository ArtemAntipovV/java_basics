package org.example;


import org.example.parcingFiles.ParsingJson;
import org.example.parcingFiles.parcingCvs.ParcingCsv;
import org.example.parcingJsoup.ParcingJsoup;

import java.io.File;
import java.util.List;

public class App
{
    private final static String PATH_DEPTHS_1 = "data/json/depths-1.json";


    public static void main( String[] args ) {
        // парсинг html
        String html = ParcingJsoup.getHtml("https://skillbox-java.github.io/");
        System.out.println(html);

        // парсинг линий
        String fileLines ="https://skillbox-java.github.io/";
        List<String> lines =  ParcingJsoup.parseFileLine(fileLines);
        System.out.println("Линии метро:");
        lines.forEach(System.out::println);

        // парсинг станций
        String fileStantion = "https://skillbox-java.github.io/";
        List<String> stantion = ParcingJsoup.parseFileStation(fileStantion);
        System.out.println("Станции метро:");
        stantion.forEach(System.out::println);

//        // нахождение файлов
//        String rootDirectory = "D:\\Загрузки\\123\\stations-data";
//            List<String> foundFiles = FindFiles.searchFiles(rootDirectory);
//                System.out.println("Найденные файлы:");
//                foundFiles.forEach(System.out::println);

        // парсинг Json файлов
        ParsingJson parsingJson = new ParsingJson();
        parsingJson.parcingJsonFiles(PATH_DEPTHS_1);
//        parsingJson.parcingJsonFiles("data/json/depths-2.json");
//        parsingJson.parcingJsonFiles("data/json/depths-3.json");

        // парсинг Csv файлов;

        ParcingCsv parcingCsv = new ParcingCsv();
        parcingCsv.parcingCsvFiles(new File("data/csv/dates-1.csv"));
        parcingCsv.parcingCsvFiles(new File("data/csv/dates-2.csv"));
        parcingCsv.parcingCsvFiles(new File("data/csv/dates-3.csv"));





//        List<MoscowMetroLines> lines = ParcingWeb.getMetroLines(url);
//        ParcingWeb.printMetroLines(lines);
//        List<MoscowMetroStation> stations = ParcingWeb.getMetroStation(url);
//        ParcingWeb.printMetroStation(stations);
//        Path linesFilePath = Paths.get("lines.json");
//        Path stationsFilePath = Paths.get("stations.json");
//
//        ParcingWeb.writeMetroLinesTo(lines, linesFilePath);
//        ParcingWeb.writeMetroStationsTo(stations, stationsFilePath);



    }
}
