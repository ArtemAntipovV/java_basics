package org.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParcingWeb {



    public static   String getHtml(String url) {
            try {
                Document doc = Jsoup.connect(url).get();
                return doc.html();
            } catch (Exception e) {
               e.printStackTrace();
                return null;
            }
    }


}
