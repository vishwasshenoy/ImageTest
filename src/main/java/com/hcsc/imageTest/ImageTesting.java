package com.hcsc.imageTest;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * Class file to extract text from Image
 * @author i366155
 *
 */
public class ImageTesting 
{
    public static void main( String[] args ) throws IOException{
    	
        ImageTesting it = new ImageTesting();
        it.testImage();
        
    }
    
    
    public void testImage() throws IOException {
    	
    	//file path
    	String originalImageFilePath = "src"+getFileSeparator()+"main"+getFileSeparator()+"java"+getFileSeparator()+"files"+getFileSeparator()+"image5.jpg";
    	String modifiedImageFilePath = "src"+getFileSeparator()+"main"+getFileSeparator()+"java"+getFileSeparator()+"files"+getFileSeparator()+"image_Mod.jpg";
    	
    	//Original image object
    	BufferedImage original_Image = null;
    	File orig_Image_File = new File(originalImageFilePath);
    	
    	original_Image =  ImageIO.read(orig_Image_File);
    	
    	
    	//New Rectangle Dimension
    	//Rectangle rect = new Rectangle(1900,270);
    	
    	//Crop the image
    	File modified_Image_File = new File(modifiedImageFilePath);
    	ImageIO.write(cropImage(original_Image), "jpg", modified_Image_File);
    	
    	//Read the text from image
    	String textInImage = extractText_Image(modifiedImageFilePath);
    	
    	System.out.println("\n\nText in the image \""+modifiedImageFilePath+"\" is\n--------------------------");
    	System.out.println(textInImage);
		
    	
    }
    
    private BufferedImage cropImage(BufferedImage src) {
        BufferedImage dest = src.getSubimage(100, 100,100, 100);
        Graphics2D drawer = dest.createGraphics() ;
        drawer.setBackground(Color.WHITE);
        drawer.clearRect(10, 10,10, 10);
        
        return dest; 
     }
    
    /**
     * Function to extract text from image
     * @param filePath
     * @return
     */
    public  String extractText_Image(String filePath) {
		
    	File imageFile = new File(filePath);
		String TESS4J_FOLDER_PATH = "src"+getFileSeparator()+"main"+getFileSeparator()+"java"+getFileSeparator()+"tessdata";
		
		ITesseract instance = new Tesseract();
		instance.setDatapath(TESS4J_FOLDER_PATH);
		
		
		
		try {
			String result = instance.doOCR(imageFile);
			return result;
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
			return "Error while reading image";
		}
	}
    
    public static String getFileSeparator() {
		return System.getProperty("file.separator");
	}
}
