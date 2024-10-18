package parcingWeb;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.List;
import java.util.stream.Collectors;


public class MoscowMetroLinesParcing extends MoscowMetroStationParcing {


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
