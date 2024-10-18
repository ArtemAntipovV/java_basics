package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App 
{
    public static void main( String[] args ) {

//        // парсинг html
//        String html = ParcingWeb.getHtml("https://skillbox-java.github.io/");
//        System.out.println(html);
//
        // парсинг станций
        String fileLines ="https://skillbox-java.github.io/";
        List<String> lines =  MoscowMetroLines.parseFileLine(fileLines);
        System.out.println("Линии метро:");
        lines.forEach(System.out::println);

//        // парсинг линий
//        String fileStantion = "https://skillbox-java.github.io/";
//        List<String> stantion = MoscowMetroStation.parseFileStation(fileStantion);
//        System.out.println("Станции метро:");
//        stantion.forEach(System.out::println);

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
