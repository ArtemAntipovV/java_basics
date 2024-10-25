package org.example.jsonFileCreator;


import lombok.Getter;
import java.util.ArrayList;
import java.util.List;


public class Line {
    @Getter
    private String numberLine;
    @Getter
    private String nameLine;
    @Getter
    private List<String> stations;
    private List<String> line;

    public Line(String name, String number) {
        this.numberLine = number;
        this.nameLine = name;
        this.stations = new ArrayList<>();
    }

    public void addStation(String station) {
        stations.add(station);
    }

    @Override
    public String toString() {
        return "Номер линии: " + getNumberLine() + " Линия: " + getNameLine() + " Станции: " + getStations();
    }

}