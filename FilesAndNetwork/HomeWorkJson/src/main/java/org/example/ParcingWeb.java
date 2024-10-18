package org.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParcingWeb {


    public static String getHtml(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            return doc.html();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<MoscowMetroLines> getMetroLines(String url) {
//        try {
//            Document doc = Jsoup.connect(url).get();
//            Elements lines = doc.select("line");
//            List<MoscowMetroLines> linesList = new ArrayList<>();
//            for (Element line : lines) {
//                String lineName = line.select("h2").text();
//                String lineNumber = line.select("span.metro-line").text();
//                MoscowMetroLines lineObj = new MoscowMetroLines(lineName, lineNumber);
//                linesList.add(lineObj);
//            }
//            return linesList;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
   return null;
    }

    public static String getMetroStation(String url) {
//        try {
//            Document doc = Jsoup.connect(url).get();
//            Elements stations = doc.select("div.station");
//            List<MoscowMetroStation> stationsList = new ArrayList<>();
//            for (Element station : stations) {
//                String nameStation = station.select("h3").text();
//                String numberStation = station.select("span.line-number").text();
//                MoscowMetroLines stationObj = new MoscowMetroLines(nameStation, numberStation);
//
//                stationsList.add(stationObj);
//            }
//            return stationsList;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }


return null;
    }

    public static void writeMetroLinesTo(List<MoscowMetroLines> lines, Path filePath) {
        try {
            String json = lines.stream()
                    .map(MoscowMetroLines::toString)
                    .collect(Collectors.joining(", \n"));
            Files.write(filePath, json.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeMetroStationsTo(List<MoscowMetroStation> stations, Path filePath) {
        try {
            String json = stations.stream()
                    .map(MoscowMetroStation::toString)
                    .collect(Collectors.joining(", \n"));
            Files.write(filePath, json.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printMetroLines(List<MoscowMetroLines> lines) {
        if (lines != null) {
            for (MoscowMetroLines line : lines) {
                System.out.println(line.getName() + " - " + line.getNumber());
            }
        } else {
            System.out.println("No lines found.");
        }
    }

    public static void printMetroStation(List<MoscowMetroStation> lines) {
        if (lines != null) {
            for (MoscowMetroStation line : lines) {
                System.out.println(line.getNameStation() + " - " + line.getNumberStation());
            }
        } else {
            System.out.println("No lines found.");
        }
    }

}







