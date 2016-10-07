package homework3.aliaksandrah;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Multithreaded {
	public static void main(String args[]) throws InterruptedException{
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		StockThread stock = new StockThread("Stock quote"); // Stock Thread
		UniqueWords unique = new UniqueWords("Unique Words"); // Unique Words Thread
		scheduledThreadPool.execute(stock);
		scheduledThreadPool.execute(unique);
		scheduledThreadPool.shutdown();
		try{
			if(scheduledThreadPool.awaitTermination(5, TimeUnit.SECONDS)){
				System.out.println("Terminated before 5 seconds");
			} else {
				System.err.println("Threads did not finish. System aborted.");
			}
		} catch (InterruptedException e) {
            e.printStackTrace();
		}
	}
}
