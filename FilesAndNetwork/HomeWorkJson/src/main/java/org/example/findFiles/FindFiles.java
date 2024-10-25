package org.example.findFiles;



import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class FindFiles {

        public static List<String> findFiles(Path path, String[] fileExtensions) {
            List<String> result = new ArrayList<>();
            if (!Files.isDirectory(path)) {
                System.out.println("Путь должен быть каталогом!");
            } else {
                try (Stream<Path> walk = Files.walk(path)) {
                    walk
                            .filter(p -> !Files.isDirectory(p))
                            .map(p -> p.toString().toLowerCase())
                            .filter(f -> Arrays.stream(fileExtensions).anyMatch(f::endsWith))
                            .forEach(result::add);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
            return result;
        }
}
