import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;


    public class ImageResizer implements Runnable{

        private File[] files;
        private int newWidth;
        private String dstFolder;
        private long start;

        public ImageResizer(File[] files, int newWidth, String dstFolder, long start) {
            this.files = files;
            this.newWidth = newWidth;
            this.dstFolder = dstFolder;
            this.start = start;
        }


        @Override
        public void run() {
            try {
                for (File file : files) {
                    BufferedImage image = ImageIO.read(file);
                    if (image == null) {
                        continue;
                    }

                    BufferedImage newImage = Scalr.resize(image, newWidth);

                    File newFile = new File(dstFolder + File.separator + file.getName());
                    ImageIO.write(newImage, "jpg", newFile);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Finished after start: " + (System.currentTimeMillis() - start));
        }
    }

