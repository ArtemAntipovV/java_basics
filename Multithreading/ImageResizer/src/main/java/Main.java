import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int THREAD_COUNT = 6;
    private static final int NEW_WIDTH = 300;

    public static void main(String[] args) {
        String srcFolder = "D:\\Загрузки\\Машина\\src";
        String dstFolder = "D:\\Загрузки\\Машина\\dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        List<File> files = new ArrayList<>(List.of(srcDir.listFiles()));

        divideAndProcessFiles(files, THREAD_COUNT, NEW_WIDTH, dstFolder, start);

    }

    private static void divideAndProcessFiles(List<File> files, int threadCount, int newWidth, String dstFolder, long start) {
        int chunkSize = files.size() / threadCount;

        for (int i = 0; i < threadCount; i++) {
            int fromIndex = i * chunkSize;
            int toIndex = Math.min(fromIndex + chunkSize, files.size());

            List<File> sublist = files.subList(fromIndex, toIndex);
            ImageResizer resizer = new ImageResizer(sublist.toArray(new File[0]), newWidth, dstFolder, start);
            new Thread(resizer).start();
        }
    }
}
