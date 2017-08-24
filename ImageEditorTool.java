import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageEditorTool extends Canvas implements ActionListener {

JMenuBar mainmenu;
JMenu file;
JMenu edit;
JMenuItem open, save, exit, contrastIncrease, contrastDecrease, brightnessIncrease, brightnessDecrease, sharpnessIncrease, blur, edgeDetect, invertColor, invertBlue, posterize, imageThreshold, zoomIn, zoomOut, rotate, imagePrewitt, imageLaplacian;
String fileName;

JFrame frame = new JFrame("Image Editor");
JLabel label = new JLabel();
DigitaIImageProcessing dip = new ImageEditor();

//DESIGN THE OUTER CLASS WITH ALL THE GUI COMPONENTS

void Main(){
	
 Container cont = frame.getContentPane();
 
 edit = new JMenu("EDIT");
 contrastIncrease = new JMenuItem("CONTRAST INCREASE");
 contrastIncrease.addActionListener(this);
 edit.add(contrastIncrease);
 contrastDecrease = new JMenuItem("CONTRAST DECREASE");
 contrastDecrease.addActionListener(this);
 edit.add(contrastDecrease);
 brightnessIncrease = new JMenuItem("BRIGHTNESS INCREASE");
 edit.add(brightnessIncrease);
 brightnessIncrease.addActionListener(this);
 brightnessDecrease = new JMenuItem("BRIGHTNESS DECREASE");
 edit.add(brightnessDecrease);
 brightnessDecrease.addActionListener(this);
 sharpnessIncrease = new JMenuItem("SHARPNESS INCREASE");
 edit.add(sharpnessIncrease);
 sharpnessIncrease.addActionListener(this);
 blur = new JMenuItem("BLUR IMAGE");
 blur.addActionListener(this);
 edit.add(blur);
 edgeDetect = new JMenuItem("EDGE DETECT");
 edgeDetect.addActionListener(this);
 edit.add(edgeDetect);
 invertColor = new JMenuItem("INVERT COLOR");
 invertColor.addActionListener(this);
 edit.add(invertColor);
 invertBlue = new JMenuItem("INVERT BLUE");
 invertBlue.addActionListener(this);
 edit.add(invertBlue);
 posterize = new JMenuItem("POSTERIZE IMAGE");
 posterize.addActionListener(this);
 edit.add(posterize);
 imageThreshold = new JMenuItem("IMAGE THRESHOLD");
 imageThreshold.addActionListener(this);
 edit.add(imageThreshold);
 zoomIn = new JMenuItem("ZOOM");
 zoomIn.addActionListener(this);
 edit.add(zoomIn);
 zoomOut = new JMenuItem("ZOOM OUT");
 zoomOut.addActionListener(this);
 edit.add(zoomOut);
 rotate = new JMenuItem("ROTATE");
 rotate.addActionListener(this);
 edit.add(rotate);
 imagePrewitt = new JMenuItem("APPLY PREWITT EFFECT");
 imagePrewitt.addActionListener(this);
 edit.add(imagePrewitt);
 imageLaplacian = new JMenuItem("APPLY LAPLACIAN EFFECT");
 imageLaplacian.addActionListener(this);
 edit.add(imageLaplacian);
 
 
 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
 label.setIcon(icon);
 frame.add(label, BorderLayout.CENTER);
 
 
 mainmenu = new JMenuBar();
 
 mainmenu.add(edit);
 frame.setJMenuBar(mainmenu);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setSize(700, 700);
 frame.setVisible(true);
 
}

@Override
public void actionPerformed(ActionEvent event) {
	// TODO Auto-generated method stub
	if (event.getSource() == contrastIncrease){
		
		 ImageEditor editContrast = new ImageEditor();	
		 File f = editContrast.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= editContrast.imageWidth(f);
		 int height= editContrast.imageHeight(f);
		 BufferedImage buffer = editContrast.Image2Buffer(f,width,height);
		 buffer = editContrast.contrastIncrease(buffer,10);
		 File outputFile = editContrast.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		
	}
	
	if (event.getSource() == contrastDecrease){
		
		 ImageEditor editContrast = new ImageEditor();	
		 File f = editContrast.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= editContrast.imageWidth(f);
		 int height= editContrast.imageHeight(f);
		 BufferedImage buffer = editContrast.Image2Buffer(f,width,height);
		 buffer = editContrast.contrastDecrease(buffer,10);
		 File outputFile = editContrast.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		
	}
	
	if (event.getSource() == brightnessIncrease){
		
		 ImageEditor editBrightness = new ImageEditor();	
		 File f = editBrightness.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= editBrightness.imageWidth(f);
		 int height= editBrightness.imageHeight(f);
		 BufferedImage buffer = editBrightness.Image2Buffer(f,width,height);
		 buffer = editBrightness.brightnessIncrease(buffer, 0.2f);
		 File outputFile = editBrightness.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}		
	if (event.getSource() == brightnessDecrease){
		
		 ImageEditor editBrightness = new ImageEditor();	
		 File f = editBrightness.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= editBrightness.imageWidth(f);
		 int height= editBrightness.imageHeight(f);
		 BufferedImage buffer = editBrightness.Image2Buffer(f,width,height);
		 buffer = editBrightness.brightnessDecrease(buffer, 0.2f);
		 File outputFile = editBrightness.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}
	if (event.getSource() == sharpnessIncrease){
		
		 ImageEditor editSharpness = new ImageEditor();	
		 File f = editSharpness.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= editSharpness.imageWidth(f);
		 int height= editSharpness.imageHeight(f);
		 BufferedImage buffer = editSharpness.Image2Buffer(f,width,height);
		 buffer = editSharpness.sharpnessIncrease(buffer);
		 File outputFile = editSharpness.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}
	if (event.getSource() == blur){
		
		 ImageEditor blur = new ImageEditor();	
		 File f = blur.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= blur.imageWidth(f);
		 int height= blur.imageHeight(f);
		 BufferedImage buffer = blur.Image2Buffer(f,width,height);
		 buffer = blur.blurImage(buffer);
		 File outputFile = blur.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}
	if (event.getSource() == edgeDetect){
		
		 ImageEditor edgeDetect = new ImageEditor();	
		 File f = edgeDetect.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= edgeDetect.imageWidth(f);
		 int height= edgeDetect.imageHeight(f);
		 BufferedImage buffer = edgeDetect.Image2Buffer(f,width,height);
		 buffer = edgeDetect.edgeDetectImage(buffer);
		 File outputFile = edgeDetect.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}
	if (event.getSource() == invertColor){
		
		 ImageEditor invertColor = new ImageEditor();	
		 File f = invertColor.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= invertColor.imageWidth(f);
		 int height= invertColor.imageHeight(f);
		 BufferedImage buffer = invertColor.Image2Buffer(f,width,height);
		 buffer = invertColor.invertImageColor(buffer);
		 File outputFile = invertColor.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}
	if (event.getSource() == invertBlue){
		
		 ImageEditor invertBlue = new ImageEditor();	
		 File f = invertBlue.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= invertBlue.imageWidth(f);
		 int height= invertBlue.imageHeight(f);
		 BufferedImage buffer = invertBlue.Image2Buffer(f,width,height);
		 buffer = invertBlue.invertBlueColor(buffer);
		 File outputFile = invertBlue.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}
	if (event.getSource() == posterize){
		
		 ImageEditor poster = new ImageEditor();	
		 File f = poster.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= poster.imageWidth(f);
		 int height= poster.imageHeight(f);
		 BufferedImage buffer = poster.Image2Buffer(f,width,height);
		 buffer = poster.posterizeImage(buffer);
		 File outputFile = poster.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}	
	if (event.getSource() == zoomIn){
		
		 ImageEditor zoomImg = new ImageEditor();	
		 File f = zoomImg.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= zoomImg.imageWidth(f);
		 int height= zoomImg.imageHeight(f);
		 BufferedImage buffer = zoomImg.Image2Buffer(f,width,height);
		 buffer = zoomImg.zoom(buffer,150);
		 File outputFile = zoomImg.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}		
	if (event.getSource() == zoomOut){
		
		 ImageEditor zoomOImg = new ImageEditor();	
		 File f = zoomOImg.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= zoomOImg.imageWidth(f);
		 int height= zoomOImg.imageHeight(f);
		 BufferedImage buffer = zoomOImg.Image2Buffer(f,width,height);
		 buffer = zoomOImg.zoomOut(buffer,150);
		 File outputFile = zoomOImg.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}	
	if (event.getSource() == rotate){
		
		 ImageEditor rImg = new ImageEditor();	
		 File f = rImg.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= rImg.imageWidth(f);
		 int height= rImg.imageHeight(f);
		 BufferedImage buffer = rImg.Image2Buffer(f,width,height);
		 buffer = rImg.rotate(buffer);
		 File outputFile = rImg.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}		
	if (event.getSource() == imagePrewitt){
		
		 ImageEditor imgP = new ImageEditor();	
		 File f = imgP.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= imgP.imageWidth(f);
		 int height= imgP.imageHeight(f);
		 BufferedImage buffer = imgP.Image2Buffer(f,width,height);
		 buffer = imgP.imagePrewittOp(buffer);
		 File outputFile = imgP.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}
	if (event.getSource() == imageLaplacian){
		
		 ImageEditor imgL = new ImageEditor();	
		 File f = imgL.Inputfile("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-01.jpg");
		 int width= imgL.imageWidth(f);
		 int height= imgL.imageHeight(f);
		 BufferedImage buffer = imgL.Image2Buffer(f,width,height);
		 buffer = imgL.laplacianOpPos(buffer);
		 File outputFile = imgL.output(buffer, "C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 ImageIcon icon = new ImageIcon("C:\\Users\\Mohd\\Pictures\\x-men-first-class-professor-x-character-poster-edit.jpg");
		 label.setIcon(icon);
		 
	}	
}

public static void main(String[] args){
	
	ImageEditorTool imgTool = new ImageEditorTool();
	imgTool.Main();
	
}

}
