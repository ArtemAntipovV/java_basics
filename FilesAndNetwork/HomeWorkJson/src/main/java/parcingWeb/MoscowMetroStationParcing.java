package parcingWeb;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.List;
import java.util.stream.Collectors;


public class MoscowMetroStationParcing {

    public static List<String> parseFileStation (String path) {
        try {
            Document doc = Jsoup.connect(path).get();
            // выбираем и получаем станции и номер
            Elements stations = doc.select("div.js-metro-stations");
            List<String> stationNumber = stations.stream()
                    .map(station -> station.select("span.js-metro-line").attr("span.line")
                             + station.text())
                    .collect(Collectors.toList());
        return stationNumber;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

