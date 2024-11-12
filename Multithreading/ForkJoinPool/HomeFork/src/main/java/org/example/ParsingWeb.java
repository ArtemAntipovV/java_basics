package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.IIOException;

public class ParsingWeb extends RecursiveTask<List<Link>> {


    private final List<Link> linkList = Collections.synchronizedList(new ArrayList<>());
    private  String startUrl;
    private static Set<String> visitedUrls = ConcurrentHashMap.newKeySet();
    private  List<ParsingWeb> taskList = Collections.synchronizedList(new ArrayList<>());

    public ParsingWeb(String startUrl) {
        this.startUrl = startUrl;

    }
    @Override
    protected List<Link> compute() {
            int linkLevel = 1;
        for (Element element : getElements()) {
            String linkUrl = element.absUrl("href");
            if (linkUrl.startsWith(startUrl) && !visitedUrls.contains(linkUrl) &&
                    !linkUrl.contains("#") && !linkUrl.endsWith(".pdf") && !linkUrl.equals("/")) {
                visitedUrls.add(linkUrl);
                linkList.add(new Link(linkUrl, linkLevel));
                ParsingWeb task = new ParsingWeb(linkUrl);
                taskList.add(task);
                task.fork();
                linkLevel++;
            }
            }
        List<Future<List<Link>>> futures = new ArrayList<>();
        for (ParsingWeb task : taskList) {
            futures.add(ForkJoinPool.commonPool().submit(task));
        }

        for (Future<List<Link>> future : futures) {
            try {
                linkList.addAll(future.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace(); // Обрабатываем исключения
            }
        }

        return linkList;
        }


    public void writeResults(List<Link> links) {
        StringBuilder sb = new StringBuilder();
        try {
            FileWriter writer = new FileWriter("HomeFork/results.txt", true);
            PrintWriter printWriter = new PrintWriter(writer);

            for (Link link : links) {
                sb.append("\t".repeat(link.getLevel())) // Добавляем отступы
                        .append(link.getNameLink())
                        .append("\n");
            }

            printWriter.print(sb.toString());
            printWriter.close();
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
            throw new RuntimeException(e);
        }


    }

    private Elements getElements() {
        Elements elements;
        Document doc;
        try {
            doc = Jsoup.connect(startUrl)
                    .ignoreHttpErrors(true)
                    .ignoreContentType(true)
                    .maxBodySize(0)
                    .timeout(10_000)
                    .get();
            elements = doc.select("a[href]");
        } catch (IOException e) {
            System.err.println("Не удалось получить документ: " + startUrl);
            throw new RuntimeException(e);
        }
        return elements;
    }
}
