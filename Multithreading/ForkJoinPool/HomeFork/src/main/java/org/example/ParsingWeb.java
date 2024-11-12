package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveAction;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParsingWeb extends RecursiveAction {
    private static final int MAX_DEPTH = 10; // Максимальная глубина обхода
    private static final int TIMEOUT_MILLIS = 30_000;


    private final String startUrl;
    private Set<String> visitedUrls = new HashSet<>();
    private final int depth;
    private PrintWriter writer;

    public ParsingWeb(String startUrl, Set<String> visitedUrls, int depth, PrintWriter writer) {
        this.startUrl = startUrl;
        this.visitedUrls = visitedUrls;
        this.depth = depth;
        this.writer = writer;
    }

    @Override
    protected void compute() {
        if (depth > MAX_DEPTH || startUrl == null) {
            return;
        }

        try {
            Thread.sleep(150);
            Connection connection = Jsoup.connect(startUrl)
                    .timeout(TIMEOUT_MILLIS)
                    .userAgent("Mozilla");

            Document document = connection.get();
            Elements links = document.select("a[href]");

            List<ParsingWeb> tasks = new ArrayList<>();
            for (Element link : links) {
                String absHref = link.absUrl("href");
                if (!visitedUrls.contains(absHref) && absHref.startsWith(startUrl)) {
                    visitedUrls.add(absHref);
                    writeToFile(depth, absHref);
                    tasks.add(new ParsingWeb(absHref, visitedUrls, depth + 1, writer));
                }
            }

            invokeAll(tasks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(int depth, String url) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        writer.write(sb + url + "\n");
    }
}