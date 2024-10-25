package org.example.parseFiles.parseCvs;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ParseCsv {
    private ArrayList<String> lines = new ArrayList<>();
    private Map<String, String> stantionDate = new HashMap<>();

    public List<String> parcingCsvFiles(String path) {
        ArrayList<String> line;
        try {
            line = (ArrayList<String>) Files.readAllLines(Paths.get(path));
            lines.addAll(line);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return lines;
    }

    public Map<String, String> splitCsv() {
        String firstLine = null;
        for (String line : lines) {
            if (firstLine == null) {
                firstLine = line;
                continue;
            }
            String[] tokens = line.split(",");
            stantionDate.put(tokens[0], tokens[1]);
        }
        return stantionDate;
    }

    public Map<String, String> getStationsDate() {
        return stantionDate;
    }

}



