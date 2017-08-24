import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.RescaleOp;
import java.awt.image.ShortLookupTable;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageEditor extends Imaging implements DigitaIImageProcessing  {

@Override
public BufferedImage contrastIncrease(BufferedImage buffer, int incrementAmount) {

	RescaleOp contrast = new RescaleOp(1.0f, 0.0f + (float)(incrementAmount), null);
	buffer = contrast.filter(buffer, null);
	return buffer;

	}
@Override
public  BufferedImage contrastDecrease(BufferedImage buffer, int decrementAmount){

	RescaleOp contrast = new RescaleOp(1.0f, 0.0f - (float)(decrementAmount), null);
    buffer = contrast.filter(buffer, null);
	return buffer;
}


@Override
public BufferedImage grayscaleImage(BufferedImage buffer) {
	

 for (int i=0;i<=buffer.getHeight()-1;i++){
	 
  for (int j=0;j<=buffer.getWidth()-1;j++){
	  
	  Color c = new Color(buffer.getRGB(j, i));
	  int red = (int)(c.getRed() * 0.299);
	  int green =(int)(c.getGreen() * 0.587);
	  int blue = (int)(c.getBlue() *0.114);
	  Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);
	  buffer.setRGB(j, i, newColor.getRGB());
  }
	 
	 
 }
   //RescaleOp op = new RescaleOp(2.0f, 0.0f, null);
  // bufferEdit = op.filter(buffer, null);
   return buffer;
}

@Override
public BufferedImage brightnessIncrease(BufferedImage buffer, float incrementAmount){
	
	  RescaleOp op = new RescaleOp(1.0f + incrementAmount, 0.0f, null);
	  buffer = op.filter(buffer, null);
	  return buffer;
}

@Override
public BufferedImage brightnessDecrease(BufferedImage buffer, float decrementAmount){
	
	  RescaleOp op = new RescaleOp(1.0f-decrementAmount, 0.0f, null);
	  buffer = op.filter(buffer, null);
	  return buffer;
}


public BufferedImage sharpnessIncrease(BufferedImage buffer){
	
	Graphics graphics = buffer.createGraphics();
	float ninth = 1.0f/9.0f;
	Kernel kernel = new Kernel(3,3, new float[]{0,-1,0,-1,5,-1,0,-1, 0});
	BufferedImageOp op = new ConvolveOp(kernel);
	buffer = op.filter(buffer, null);
	return buffer;
}
@Override
public BufferedImage blurImage(BufferedImage buffer){
	
	Graphics graphics = buffer.createGraphics();
	float ninth = 1.0f/9.0f;
	Kernel kernel = new Kernel(3,3, new float[]{ninth,ninth,ninth,ninth,ninth,ninth,ninth,ninth, ninth});
	BufferedImageOp op = new ConvolveOp(kernel);
	buffer = op.filter(buffer, null);
	return buffer;
}
@Override
public BufferedImage edgeDetectImage(BufferedImage buffer){
	
	Graphics graphics = buffer.createGraphics();
	Kernel kernel = new Kernel(3,3, new float[]{0,-1,0,-1,4,-1,0,-1, 0});
	BufferedImageOp op = new ConvolveOp(kernel);
	buffer = op.filter(buffer, null);
	return buffer;
}
@Override
public BufferedImage invertImageColor(BufferedImage buffer){
	short[] invert = new short[256];
	for (int i = 0; i < 256; i++){
	  invert[i] = (short)(255 - i);
      }
	 BufferedImageOp invertOp = new LookupOp(new ShortLookupTable(0, invert), null);
	 buffer = invertOp.filter(buffer, buffer);
	 return buffer;
}
@Override
public BufferedImage invertBlueColor(BufferedImage buffer){
	 short[] invert = new short[256];
	 short[] straight = new short[256];
	 for (int i = 0; i < 256; i++) {
	   invert[i] = (short)(255 - i);
	   straight[i] = (short)i;
	 }
	short[][] blueInvert = new short[][] { straight, straight, invert };
	BufferedImageOp blueInvertOp =new LookupOp(new ShortLookupTable(0, blueInvert), null);
    buffer = blueInvertOp.filter(buffer, buffer);
    return buffer;
}
@Override
public BufferedImage posterizeImage(BufferedImage buffer){
	short[] posterize = new short[256];
	for (int i = 0; i < 256; i++){
	posterize[i] = (short)(i - (i % 32));
	}
	
	BufferedImageOp posterizeOp = new LookupOp(new ShortLookupTable(0, posterize), null);
	buffer = posterizeOp.filter(buffer, buffer);
    return buffer;
}
@Override
public BufferedImage imageThresholdOp(int threshold,int minimum, int maximum, BufferedImage buffer) {
	short[] thresholdArray = new short[256];
	  for (int i = 0; i < 256; i++) {
	   if (i < threshold){
	      thresholdArray[i] = (short)minimum;
	      }
	      else{
	        thresholdArray[i] = (short)maximum;
	        }
	      }
	    BufferedImageOp thresholdOp =  new LookupOp(new ShortLookupTable(0, thresholdArray), null);
	    buffer = thresholdOp.filter(buffer, buffer);
	    return buffer;
	  }
@ Override
public BufferedImage zoom(BufferedImage buffer, int zoomLevel){
 int newWidth;
 int newHeight;
   if (zoomLevel>100){
     newWidth = buffer.getWidth()*zoomLevel/100;
	 newHeight = buffer.getHeight()*zoomLevel/100;
	 BufferedImage resizedImage = new BufferedImage(newWidth,newHeight, BufferedImage.TYPE_INT_RGB);
	 Graphics2D g = resizedImage.createGraphics();
	 g.drawImage(buffer,0,0,newWidth,newHeight,null);
	 return resizedImage;
	 }
	 else{
		 return buffer;
	 }
}
@ Override
public BufferedImage zoomOut(BufferedImage buffer, int zoomLevel){
 int newWidth;
 int newHeight;
	 if (zoomLevel<100){
	  newWidth = buffer.getWidth()*zoomLevel/100;
	  newHeight = buffer.getHeight()*zoomLevel/100;
	BufferedImage resizedImage = new BufferedImage(newWidth,newHeight, BufferedImage.TYPE_INT_RGB);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(buffer,0,0,newWidth,newHeight,null);
	return resizedImage;
	 }
	 else{
		 return buffer;
	 }
}
@Override
public BufferedImage rotate(BufferedImage buffer){
	
	int width = buffer.getWidth();
	int height = buffer.getHeight();
	BufferedImage imageRotation = new BufferedImage(width, height, buffer.getType());
	Graphics2D g2 = imageRotation.createGraphics();
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2.rotate(Math.toRadians(90), width/2 , height/2);
	g2.drawImage(buffer, null,0,0);
	return imageRotation;
}
@Override
public BufferedImage imagePrewittOp(BufferedImage buffer){
	
	Graphics graphics = buffer.createGraphics();
	Kernel kernel = new Kernel(3,3, new float[]{-1,0,1,-1,0,1,-1,0, 1});
	BufferedImageOp op = new ConvolveOp(kernel);
	buffer = op.filter(buffer, null);
	return buffer;
}
@Override
public BufferedImage laplacianOpPos(BufferedImage buffer){
	
	Graphics graphics = buffer.createGraphics();
	Kernel kernel = new Kernel(3,3, new float[]{0,1,0,1,-4,1,0,1, 0});
	BufferedImageOp op = new ConvolveOp(kernel);
	buffer = op.filter(buffer, null);
	return buffer;
}
@Override
public BufferedImage laplacianOpNeg(BufferedImage buffer){
	
	Graphics graphics = buffer.createGraphics();
	Kernel kernel = new Kernel(3,3, new float[]{0,-1,0,-1,4,-1,0,-1, 0});
	BufferedImageOp op = new ConvolveOp(kernel);
	buffer = op.filter(buffer, null);
	return buffer;
}
@ Override
public File output(BufferedImage bufferEdit, String outputFilePath) {

File outputFile = null;;		
		
try{
    outputFile = new File(outputFilePath);
    ImageIO.write(bufferEdit, "jpg", outputFile);
			} 

catch(IOException ioe){}

return outputFile;
}

}
