package homework3.aliaksandrah;

import java.sql.SQLException;

public class UniqueWords extends Thread{
	public UniqueWords(String threadName){
		super(threadName); // name your thread
	}
	
	public void run(){
		int count = 0;
		try {
			count = WorkingWithStrings.uniqueWords();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Unique Words Thread");
		System.out.println("The number of words entered " + count);
	}
}
