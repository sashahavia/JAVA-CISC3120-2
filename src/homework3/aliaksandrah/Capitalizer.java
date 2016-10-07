package homework3.aliaksandrah;

public class Capitalizer {
	public static String capitalize(String s) {
    	if (s.length() == 0) {
    		return s;
    	}
    	String s1 = s.substring(0, 1);
    	String s2 = s.substring(0, 1).toUpperCase();
    	// compare first character if it is capitalized - skip
    	if(s1.equals(s2)){
    		return s;
    	} else {
    		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    	} 
    }
}
