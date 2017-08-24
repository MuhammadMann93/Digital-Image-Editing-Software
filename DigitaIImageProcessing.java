import java.awt.image.*;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public interface DigitaIImageProcessing {

File Inputfile(String filePath);
int imageWidth(File file);
int imageHeight(File file);
BufferedImage Image2Buffer(File file, int width, int height);
BufferedImage grayscaleImage(BufferedImage buffer);
BufferedImage contrastDecrease(BufferedImage buffer, int decrementAmount);
BufferedImage contrastIncrease(BufferedImage buffer, int incrementAmount);
BufferedImage brightnessIncrease(BufferedImage buffer, float incrementAmount);
BufferedImage brightnessDecrease(BufferedImage buffer, float decrementAmount);
BufferedImage sharpnessIncrease(BufferedImage buffer);
BufferedImage blurImage(BufferedImage buffer);
BufferedImage edgeDetectImage(BufferedImage buffer);
BufferedImage invertImageColor(BufferedImage buffer);
BufferedImage invertBlueColor(BufferedImage buffer);
BufferedImage posterizeImage(BufferedImage buffer);
BufferedImage imageThresholdOp(int threshold,int minimum, int maximum, BufferedImage buffer);
BufferedImage zoom(BufferedImage buffer, int zoomLevel);
BufferedImage zoomOut(BufferedImage buffer, int zoomLevel);
BufferedImage rotate(BufferedImage buffer);
BufferedImage imagePrewittOp(BufferedImage buffer);
BufferedImage laplacianOpPos(BufferedImage buffer);
BufferedImage laplacianOpNeg(BufferedImage buffer);
//OTHER METHODS
//ADD TEXT TO AN IMAGE
File output(BufferedImage Edit, String outputFile);



	
}
