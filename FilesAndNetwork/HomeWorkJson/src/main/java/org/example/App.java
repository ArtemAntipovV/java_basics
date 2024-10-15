package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App 
{
    public static void main( String[] args )
    {
        String html = ParcingWeb.getHtml("https://skillbox-java.github.io/");
        System.out.println(html);
    }



}
