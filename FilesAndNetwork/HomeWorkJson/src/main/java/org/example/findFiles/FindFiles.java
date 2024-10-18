package org.example.findFiles;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class FindFiles {

    public static List<String> searchFiles(String rootDirectore)  {
        List<String> foundFiles = new ArrayList<>();
        try (Stream<Path> walkStream = Files.walk(Paths.get(rootDirectore))) {
            walkStream.filter(p -> p.toFile().isFile())
                    .forEach(f -> {
                        if (f.toString().endsWith(".json") || f.toString().endsWith(".csv")) {
                            foundFiles.add(f.toFile().getAbsolutePath());
                        }
                    });
            return foundFiles;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
