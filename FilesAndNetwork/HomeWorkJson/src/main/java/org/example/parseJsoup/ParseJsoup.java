package org.example.parseJsoup;


import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ParseJsoup {

    private String parseHtml;
    private String path;
    @Getter
    private Elements elementsOfLines;
    @Getter
    private Elements elementsOfStations;
    @Getter
    private Elements elementsOfConnection;

    public ParseJsoup(String path) {
        this.path = path;
        parseHtml();
        parseFileLine();
        parseFileStation();
        parseFileConnect();
    }

    public  String parseHtml() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                parseHtml += line + "\r\n";
            }
        }
            catch (Exception e) {
            e.printStackTrace();
        }
            return parseHtml;
    }

    public  Elements parseFileLine() {
        try {
            // получаем данные о линиях
            Document doc = Jsoup.parse(parseHtml);
            // выбираем и получаем линии и номера метро
            elementsOfLines = doc.getElementsByAttributeValueStarting("class",
                    "js-metro-line t-metrostation-list-header t-icon-metroln ln");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  elementsOfLines;
    }

    public Elements parseFileStation () {
        try {
            Document doc = Jsoup.parse(parseHtml);
            elementsOfStations = doc.getElementsByClass("js-metro-stations");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  elementsOfStations;
    }

    public Elements parseFileConnect(){
        try {
            Document doc = Jsoup.parse(parseHtml);
            elementsOfConnection = doc.getElementsByClass("js-metro-stations t-metrostation-list-table");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return elementsOfConnection;
    }


}








