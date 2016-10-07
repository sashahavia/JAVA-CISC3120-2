package homework3.aliaksandrah;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileReader {
	public static void readFile(StringBuffer buffer){
   	 try (
   		FileInputStream myFile = new FileInputStream("original.txt");
   	    InputStreamReader inputStreamReader = new InputStreamReader(myFile, "UTF-8");
   	    Reader reader = new BufferedReader(inputStreamReader);){
   	    int ch; // the code of one character
   	    while ((ch = reader.read()) > -1) {
   	    	buffer.append((char)ch);
   	    }
   	  } catch (IOException e) {
   	        e.printStackTrace();
   	  }
   }
}
