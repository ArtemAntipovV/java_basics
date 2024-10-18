package org.example;


import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MoscowMetroStation {

    private String  nameStation;
    private String numberStation;


    public static List<String> parseFileStation (String path) {
        try {
            Document doc = Jsoup.connect(path).get();
            Elements stations = doc.select("p.single-station");
            List<String> stationNumber = stations.stream()
                    .map(station -> station.select("p.single-station").attr("spun.num")
                             + station.text())
                    .collect(Collectors.toList());
        return stationNumber;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

