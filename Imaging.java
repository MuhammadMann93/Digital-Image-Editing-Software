import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public abstract class Imaging implements DigitaIImageProcessing {
	
public File Inputfile(String filePath) {
		
		File f = new File(filePath);
		return f;
	}

public int imageWidth(File f){
  
int width=0;	
try{	
  Image imageFile  = ImageIO.read(f);	
  width = imageFile.getWidth(null);
}

catch(IOException ioe){}
		
return width;
}
public int imageHeight(File f){

 int height=0;	
try{	
    Image imageFile  = ImageIO.read(f);	
	height = imageFile.getHeight(null);
}

catch(IOException ioe){}
			
return height;
	
		
}
	

public BufferedImage Image2Buffer(File f, int width, int height) {

        BufferedImage buffer = new BufferedImage(width, height,  BufferedImage.TYPE_INT_RGB ); 
  
try{	
	buffer = ImageIO.read(f);
}
catch(IOException ioex){}
        
		return buffer;
}

public abstract BufferedImage grayscaleImage(BufferedImage buffer);
public abstract BufferedImage contrastIncrease(BufferedImage buffer, int incrementAmount);
public abstract BufferedImage brightnessIncrease(BufferedImage buffer, float incrementAmount);
public abstract BufferedImage brightnessDecrease(BufferedImage buffer, float decrementAmount);
public abstract BufferedImage sharpnessIncrease(BufferedImage buffer);
public abstract BufferedImage blurImage(BufferedImage buffer);
public abstract BufferedImage edgeDetectImage(BufferedImage buffer);
public abstract BufferedImage invertImageColor(BufferedImage buffer);
public abstract BufferedImage invertBlueColor(BufferedImage buffer);
public abstract BufferedImage posterizeImage(BufferedImage buffer);
public abstract BufferedImage imageThresholdOp(int threshold,int minimum, int maximum, BufferedImage buffer);
public abstract BufferedImage zoom(BufferedImage buffer, int zoomLevel);
public abstract BufferedImage zoomOut(BufferedImage buffer, int zoomLevel);
public abstract BufferedImage rotate(BufferedImage buffer);
public abstract BufferedImage imagePrewittOp(BufferedImage buffer);
//public abstract BufferedImage addBorder(BufferedImage buffer);


public static void main(String[] args){
	
 ImageEditor editSharpness = new ImageEditor();	
 File f = editSharpness.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
 int width= editSharpness.imageWidth(f);
 int height= editSharpness.imageHeight(f);
 BufferedImage buffer = editSharpness.Image2Buffer(f,width,height);
 buffer = editSharpness.laplacianOpNeg(buffer);
 File outputFile = editSharpness.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
 
	
}


}
