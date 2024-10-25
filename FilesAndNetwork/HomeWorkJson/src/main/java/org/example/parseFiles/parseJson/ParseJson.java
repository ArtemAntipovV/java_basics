package org.example.parseFiles;


import lombok.Getter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ParseJson {
    @Getter
    private Map<String, String> stationsDepth = new HashMap<>();

    public void parcingJsonFiles(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            jsonArray.forEach(stantionObject -> {
                JSONObject stantionJsonObject = (JSONObject) stantionObject;
                stationsDepth.put(
                        (String) stantionJsonObject.get("station_name"),
                        ((String) stantionJsonObject.get("depth")));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}







