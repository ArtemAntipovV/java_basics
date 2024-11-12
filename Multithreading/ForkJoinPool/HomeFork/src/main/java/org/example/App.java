package org.example;

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;


public class App
{
    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main( String[] args ) throws IOException {
        File outputFile = new File(OUTPUT_FILE_PATH);
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            Set<String> visitedUrls = new HashSet<>();
            ParsingWeb task = new ParsingWeb("https://sendel.ru/", visitedUrls, 0, writer);
            ForkJoinPool.commonPool().execute(task);
            task.join();
        }
    }
}



