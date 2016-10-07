package homework3.aliaksandrah;

//import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.Timestamp;
//import java.io.*;
//import java.util.Arrays;
//import java.util.List;
//import java.util.StringTokenizer;

public class StockQuote{
	public static int getSymbolsFromDatabase() throws SQLException{
		final String DB_URL = "jdbc:derby://localhost:1527/HW3";
		int count = 0;
		double price = 0;
		String[] word;
		String ss1 = "N/A";
		String ss2 = "";
		String ss = "";
		PreparedStatement pstmt = null;
		ResultSetMetaData rsMeta = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Timestamp ss3 = null;
		String query = "SELECT Symbol from Stocks";
		String qu = "Update Stocks Set Price = ?, LastTrade = ? WHERE Symbol = ?";
		try { 
			conn = DriverManager.getConnection(DB_URL);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			// Find out the number of columns, their names and display the data
			rsMeta = rs.getMetaData();
			int colCount = rsMeta.getColumnCount();
			while (rs.next()){ 
				for (int i = 1; i <= colCount; i++)  {
					ss = StockQuotePrinter.printStockQuote(rs.getString(i));
					word = ss.split(",");
					if (word[0].equals(ss1)){
						price = 0;
					}else{
						price = Double.parseDouble(word[0]);
					}
//					System.out.println("Word[1] " + word[1]);
					if(word[1].contains(ss1)){
						ss3 = Timestamp.valueOf("0001-01-01 00:00:00");
					}else {
						ss3 = Util.convertStringToTimestamp(word[1]);
					}
//					System.out.println("here " + ss3);
				    pstmt = conn.prepareStatement(qu); // create a statement
				    ss2 = rs.getString(i);
				    pstmt.setDouble(1, price); // set input parameter Price
				    pstmt.setTimestamp(2,ss3); // set input parameter Time
				    pstmt.setString(3, ss2); // set input parameter Symbol
				    pstmt.executeUpdate(); // execute insert statement
				    count++;
				}
				System.out.print("\n");   // new line character
			}
		} catch( SQLException se ) {
			System.out.println ("SQLError: " + se.getMessage ()
								+ " code: " + se.getErrorCode ());
		} catch( Exception e ) { 
			e.printStackTrace(); 
		} finally {
			try { if (pstmt != null) pstmt.close(); } catch (Exception e) {};
			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
		    try { if (rs != null) rs.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
		}
		return count;
	}
	
	
}