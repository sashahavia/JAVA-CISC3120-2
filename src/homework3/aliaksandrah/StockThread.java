package homework3.aliaksandrah;

import java.sql.SQLException;

public class StockThread extends Thread{
	
	public StockThread(String threadName){
		super(threadName); // name your thread
	}
	
	public void run(){
		int count = 0;
		try {	
			count = StockQuote.getSymbolsFromDatabase();	
		} catch (SQLException e) {
			e.printStackTrace(); 
		} 
		System.out.println("Stock Thread Ended");
		System.out.println("The number of records updated " + count);
	}
}
