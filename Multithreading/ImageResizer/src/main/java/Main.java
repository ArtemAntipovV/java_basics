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

        File[] files = srcDir.listFiles();
        long start = System.currentTimeMillis();

        int core = Runtime.getRuntime().availableProcessors();
        int remainder = files.length % core;
        int size = files.length / core;
        int srsPos = 0;
        for (int i = 0; i < core; i++) {
            if (i == core - 1) {
                size += remainder;
            }
            File[] newFile = new File[size];
            if (i > 0) {
                if (i == core - 1) {
                    srsPos -= remainder;
                }
                srsPos += newFile.length;
            }
            System.arraycopy(files, srsPos, newFile, 0, newFile.length);
            new Thread(new ImageResizer(newFile, NEW_WIDTH, dstFolder, start)).start();
        }
    }

}
