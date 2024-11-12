package org.example;


import java.util.List;
import java.util.concurrent.ForkJoinPool;


public class App
{


    public static void main( String[] args ) {
        ForkJoinPool pool = new ForkJoinPool();
        String startUrl = "https://sendel.ru/"; // Замените на нужный стартовый URL
        ParsingWeb task = new ParsingWeb(startUrl);
        List<Link> results = pool.invoke(task);
        task.writeResults(results);
    }
}



