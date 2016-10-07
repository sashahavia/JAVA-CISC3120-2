package homework3.aliaksandrah;

import java.util.Iterator;
import java.util.List;

public class MyIterator {
	public static void iterate(List<String> unique){
    	Iterator<String> iter = unique.iterator();
    	while (iter.hasNext()) {      // any more element
            // Retrieve the next element, explicitly downcast from Object back to String
            String str = (String)iter.next();
            if(str.length() <= 3){
            	iter.remove();
            }
         }
    }
}
