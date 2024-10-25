package org.example.jsonFileCreator;


import lombok.Getter;
import org.example.parseFiles.ParseJson;
import org.example.parseFiles.parseCvs.ParseCsv;
import org.example.parseJsoup.ParseJsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class StantionIndex {
        Station station;
        ParseJson parseJson;
        ParseJsoup parseJsoup;
        ParseCsv parseCsv;
        @Getter
        private List<Line> lines;
        @Getter
        private List<Station> stations;


        public StantionIndex(ParseJsoup parseJsoup, ParseCsv parseCsv, ParseJson parseJson) {
                this.parseJson = parseJson;
                this.parseCsv = parseCsv;
                parseCsv.splitCsv();
                this.parseJsoup = parseJsoup;
                addStations();
                addLines();
                addDate();
                addDepth();
                addConnection();
                addNameLineInStation();
                addStationInLine();

        }

        public List addLines() {
                Elements elements = parseJsoup.getElementsOfLines();
                lines = new LinkedList<>();
                elements.forEach((line) -> lines.add(new Line(line.ownText(), line.attr("data-line"))));
                return lines;
        }

        public List addStations() {
                Elements elements = parseJsoup.getElementsOfStations();
                String REGEX_FOR_STANTION = "\\d\\d?.";
                stations = new LinkedList<>();
                for(Element element : elements) {
                        String[] arrayStantion = element.text().replaceAll(REGEX_FOR_STANTION, "").split("\\s\\s");
                        for (int i = 0; i < arrayStantion.length; i++ ) {
                                station = new Station(arrayStantion[i].trim(), element.attr("data-line"));
                                stations.add(station);
                        }
                }
                return stations;
        }

        public void addConnection() {
                String REGEX_FOR_STATION = "\\d\\d?.";
                Elements elements = parseJsoup.getElementsOfConnection();
                for (Element element : elements) {
                        Elements connectionsList = element.select("p:has(span[title])");
                        for (Element connectionElement : connectionsList) {
                                String[] connectionStation = connectionElement.text().replaceAll(REGEX_FOR_STATION, "").split("\\s\\s");
                                for (String s : connectionStation) {
                                        String connection = s.trim();
                                        for (Station station1 : stations) {
                                                if (station1.getNameStation().contains(connection)) {
                                                        station1.setHasConnection(true);
                                                }
                                        }
                                }
                        }

                }
        }

        public void addNameLineInStation() {
                for (Line line1 : lines) {
                        for (Station station1 : stations) {
                                if (line1.getNumberLine().equals(station1.getNumberLine())) {
                                        station1.setNameLine(line1.getNameLine());
                                }
                        }
                }
        }

        public void addDate() {
                for (Map.Entry<String, String> entry : parseCsv.getStationsDate().entrySet()) {
                        String nameCSV = entry.getKey();
                        String dateCSV = entry.getValue();
                        for (Station station1 : stations) {
                                if (station1.getNameStation().equals(nameCSV)) {
                                        station1.setDate(dateCSV);
                                }
                        }
                }
        }

        public void addDepth() {
                for (Map.Entry<String, String> entry : parseJson.getStationsDepth().entrySet()) {
                        String nameJson = entry.getKey();
                        String depthJson = entry.getValue();
                        for (Station station1 : stations) {
                                if (station1.getNameStation().equals(nameJson)) {
                                        station1.setDepthStation(depthJson);
                                }
                        }
                }
        }
        public void addStationInLine(){
                for (Line line1 : lines) {
                        for (Station station1 : stations) {
                                if (line1.getNumberLine().equals(station1.getNumberLine())) {
                                        line1.addStation(station1.getNameStation());
                                }
                        }
                }
        }

        public void printParseCSV() {
                for (Map.Entry entry : parseCsv.getStationsDate().entrySet()) {
                        System.out.println("Название станции: " + entry.getKey() + " Дата открытия: " + entry.getValue());
                }
        }

        public void printParseJson() {
                for (Map.Entry entry : parseJson.getStationsDepth().entrySet()) {
                        System.out.println("Название станции: " + entry.getKey() + " Глубина станции: " + entry.getValue());
                }

        }


}












