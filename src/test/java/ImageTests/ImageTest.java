package ImageTests;

import junit.framework.TestCase;
import org.example.ImageProcessing.Helper.ImageReader;
import org.example.ImageProcessing.ImageRecoloring;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ImageTest extends TestCase{


        public static final String sourceFile = "C:\\Users\\hp\\Desktop\\11.jpg";
        public static final String destinationFile = "C:\\Users\\hp\\Desktop\\22.jpg";

        private ImageRecoloring imageRecolorSVC;
        private BufferedImage originalImage ;
        private BufferedImage resultImage ;
        private long startTime, endTime;
        private int numberOfThreads =100;

        @Test
        public void testRecolorImage_EmptySlice() throws IOException {
            originalImage = new ImageReader().Reader(sourceFile);
            resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            imageRecolorSVC =new ImageRecoloring(originalImage);

            resultImage =imageRecolorSVC.recolorImage(resultImage, 0, 0, 0, 0);

            assertNotEquals( "The empty slice should have return the same image ",originalImage, resultImage);

        }



}
