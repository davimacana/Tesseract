package Tesseract.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * Author:
 * D. Maçana
 *
 */
public class App {
    public static void main( String[] args ) throws TesseractException {
        
    	File imageFile = new File("images\\Step.jpeg");
		Tesseract instance = Tesseract.getInstance();
		instance.setLanguage("por");
		instance.setDatapath("C:\\dev\\OCR");
		String result = instance.doOCR(imageFile);
		
		try (Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("images\\Step.txt"), "utf-8"))) {
		   writer.write(result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(result);
    }
}
