import java.io.File;

public class Testing {

	

		public static void main(String[] args){
         DigitaIImageProcessing dip = new ImageEditor();
         File f = dip.Inputfile("C:\\Users\\Mohd\\Pictures\\maxresdefault-edit.jpg");
         System.out.println(dip.imageHeight(f));
	  
	}

}
