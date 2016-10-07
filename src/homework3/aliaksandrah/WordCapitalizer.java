package homework3.aliaksandrah;

public class WordCapitalizer {
	public static String[] capitalizeWords(String[] s){
    	for (int i=0; i < s.length; i++){
    		s[i] = Capitalizer.capitalize(s[i]);
    	}
    	return s;
    }
}
