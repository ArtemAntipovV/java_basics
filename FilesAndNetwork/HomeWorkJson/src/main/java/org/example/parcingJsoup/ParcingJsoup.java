package org.example.parcingJsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ParcingJsoup {

    public static List<String> parseFileLine(String path) {
        try {
            // получаем данные о линиях
            Document doc = Jsoup.connect(path).get();
            // выбираем и получаем линии и номера метро
            Elements lines = doc.select("div.js-toggle-depend");
            List<String> linesList = lines.stream()
                    .map(line -> line.select("span.js-metro-line").attr("data-line")
                            + " - " + line.text())
                    .collect(Collectors.toList());
            return linesList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> parseFileStation (String path) {
        try {
            Document doc = Jsoup.connect(path).get();
            // выбираем и получаем станции и номер
            Elements lines = doc.select("div.js-depend");
            List<String> stationNumber = lines.stream()
                    .map(line -> {
                        Elements lineElement = line.select("div.js-metro-stations");
                        String lineNumber = lineElement.attr("data-line");
                        List<Element> stations = line.select(".js-depend");
                        return "Линия: "  + lineNumber + "\n"
                                + "Станции: " + stations.stream()
                                .map(Element::text)
                                .collect(Collectors.joining(" "));

                    })
                    .collect(Collectors.toList());
            return stationNumber;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getHtml(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            return doc.html();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}








