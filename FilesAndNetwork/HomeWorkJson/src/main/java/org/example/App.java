package org.example;

public class App 
{
    public static void main( String[] args )
    {
        ParcingWeb htmlCode = new ParcingWeb();
        htmlCode.getHtml("https://skillbox-java.github.io/");
        System.out.println(htmlCode);
    }



}
