package homework3.aliaksandrah;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkingWithStrings {
	
    public static int uniqueWords() throws SQLException{
    	int count = 0;
    	StringBuffer buffer = new StringBuffer();
    	FileReader.readFile(buffer);
        String myString = buffer.toString();
        // Remove all punctuation
        String newLine = StringManipulator.manipulateString(myString);
    	String[] word = newLine.split(" ");
    	// Capitalize each word
    	WordCapitalizer.capitalizeWords(word);
    	List<String> wordList = Arrays.asList(word);
    	Set<String> uniqueWordsSet = new HashSet<String>(wordList);
    	List<String> uniqueWordsList = new ArrayList<String>(uniqueWordsSet);
    	Collections.sort(uniqueWordsList);
    	// Remove words that have 3 or less letters
    	MyIterator.iterate(uniqueWordsList);
//    	uniqueWordsList.forEach(uniqueWord->System.out.println(uniqueWord)); 
    	// write to the file
//    	MyFileWriter.writeDataFile(uniqueWordsList);  
    	try {
    		count = MyDataInsert.insertDataInDB(uniqueWordsList);
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    	return count;
    } 
   
}