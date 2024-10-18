package org.example;

import parcingWeb.MoscowMetroStationParcing;
import org.example.findFiles.FindFiles;

import java.util.List;

public class App 
{
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

        // парсинг станций
        String fileStantion = "https://skillbox-java.github.io/";
        List<String> stantion = MoscowMetroStationParcing.parseFileStation(fileStantion);
        System.out.println("Станции метро:");
        stantion.forEach(System.out::println);

        // нахождение файлов
        String rootDirectory = "D:\\Загрузки\\ 123\\stations-data";
            List<String> foundFiles = FindFiles.searchFiles(rootDirectory);
                System.out.println("Найденные файлы:");
                foundFiles.forEach(System.out::println);




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
