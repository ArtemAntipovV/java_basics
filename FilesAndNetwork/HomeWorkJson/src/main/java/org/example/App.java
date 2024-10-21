package org.example;


import org.example.parcingFiles.ParsingJson;
import parcingWeb.MoscowMetroLinesParcing;
import parcingWeb.MoscowMetroStationParcing;
import org.example.findFiles.FindFiles;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class App 
{
    private final static String PATH_DEPTHS_1 = "data/depths-1.json";


    public static void main( String[] args ) {


//        // парсинг html
//        String html = ParcingWeb.getHtml("https://skillbox-java.github.io/");
//        System.out.println(html);
//
//        // парсинг линий
//        String fileLines ="https://skillbox-java.github.io/";
//        List<String> lines =  MoscowMetroLinesParcing.parseFileLine(fileLines);
//        System.out.println("Линии метро:");
//        lines.forEach(System.out::println);

//        // парсинг станций
//        String fileStantion = "https://skillbox-java.github.io/";
//        List<String> stantion = MoscowMetroStationParcing.parseFileStation(fileStantion);
//        System.out.println("Станции метро:");
//        stantion.forEach(System.out::println);
//
//        // нахождение файлов
//        String rootDirectory = "D:\\Загрузки\\ 123\\stations-data";
//            List<String> foundFiles = FindFiles.searchFiles(rootDirectory);
//                System.out.println("Найденные файлы:");
//                foundFiles.forEach(System.out::println);

//        // парсинг Json файлов
//        ParsingJson parsingJson = new ParsingJson();
//        parsingJson.parcingJsonFiles(PATH_DEPTHS_1);

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
