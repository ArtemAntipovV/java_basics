package org.example;


import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class MoscowMetroLines extends MoscowMetroStation {

    private String name;
    private String number;


    public MoscowMetroLines(String nameLines, String numberLines) {
        this.name = name;
        this.number = number;
    }


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

}
