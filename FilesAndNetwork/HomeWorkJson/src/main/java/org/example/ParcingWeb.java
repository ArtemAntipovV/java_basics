package org.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ParcingWeb {

    public  String getHtml(String url) {
            try {
                Document doc = Jsoup.connect(url).get();
                return doc.html();
            } catch (Exception e) {
               e.printStackTrace();
               return null;
            }
    }
}
