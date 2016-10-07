package homework3.aliaksandrah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

public class StockQuotePrinter {
	public static String printStockQuote(String symbol){
		String csvString;
		URL url = null;
		URLConnection urlConn = null;
		String ss = null;
		InputStreamReader inStream = null;
		BufferedReader buff  = null;
		try{
			url  = new URL("http://quote.yahoo.com/d/quotes.csv?s="
							+ symbol + "&f=sl1d1t1c1ohgv&e=.csv" );
			urlConn = url.openConnection();
		} catch(IOException ioe){
			ioe.printStackTrace();
		}
		try{
			inStream = new InputStreamReader(urlConn.getInputStream());
			buff = new BufferedReader(inStream);
			// get the quote as a csv string
			csvString = buff.readLine();  
//			System.out.println(csvString);
			
			ss = cleanUpString(csvString);
		} catch(MalformedURLException e){
			System.out.println("Please check the spelling of " 
					+ "the URL: " + e.toString() );
		} catch(IOException  e1){
			System.out.println("Can't read from the Internet: " + 
					e1.toString() ); 
		} finally {
			try { if (buff != null) buff.close(); } catch (Exception e) {};
		    try { if (inStream != null) inStream.close(); } catch (Exception e) {};
		}
		System.out.println("ss " + ss);
		return ss;
   } 
	
	public static String cleanUpString(String csv){
		// Parse the csv string using StringTokenizer
		StringTokenizer tokenizer = new StringTokenizer(csv, ",");
		String ticker = tokenizer.nextToken();
		String price  = tokenizer.nextToken();
		String tradeDate = tokenizer.nextToken();  
		String tradeTime = tokenizer.nextToken();
		ticker = ticker.replaceAll("\"", "");
		tradeDate = tradeDate.replaceAll("\"", "");
		tradeTime = tradeTime.replaceAll("\"", "");
		tradeTime = tradeTime.replaceAll("pm", " pm");
		tradeTime = tradeTime.replaceAll("am", " am");
		return price + "," + tradeDate + " " + tradeTime;
	}
}
