import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Loader {

    private static final int NUM_THREADS = 4;
    private static final int REGIONS_PER_THREAD = 99 / NUM_THREADS;
    private static final char[] LETTERS = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
           int startRegion = i * REGIONS_PER_THREAD + 1;
           int endRegion = Math.min(startRegion + REGIONS_PER_THREAD, 100);
            Runnable task = () -> generateNumbers(startRegion, endRegion);
            executor.submit(task);
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

        private static void generateNumbers (int startRegion, int endRegion) {
            try (PrintWriter writer = new PrintWriter(new FileOutputStream("res/numbers_" + startRegion + "-" + endRegion + ".txt"))) {
                for (int regionCode = startRegion; regionCode < endRegion; regionCode++) {
                    for (int number = 1; number < 1000; number++) {
                        for (char firstLetter : LETTERS) {
                            for (char secondLetter : LETTERS) {
                                for (char thirdLetter : LETTERS) {
                                    writer.print(firstLetter);
                                    writer.print(padNumber(number, 3));
                                    writer.print(secondLetter);
                                    writer.print(thirdLetter);
                                    writer.print(padNumber(regionCode, 2));
                                    writer.println();
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String padNumber ( int number, int numberLength) {
            StringBuilder numberStr = new StringBuilder(Integer.toString(number));

            while (numberStr.length() < numberLength) {
                numberStr.insert(0, '0');
            }
            return numberStr.toString();
        }
    }

