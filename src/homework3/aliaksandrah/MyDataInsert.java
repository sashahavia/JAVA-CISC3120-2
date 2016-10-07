package homework3.aliaksandrah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MyDataInsert {
	public static int insertDataInDB(List<String> str) throws SQLException{
		final String DB_URL = "jdbc:derby://localhost:1527/HW3";
		int count = 0;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try { 
			conn = DriverManager.getConnection(DB_URL);
			stmt = conn.createStatement();
			String q = "Insert into Words(UniqueWord) values(?)";
			for (String ss: str){
				pstmt = conn.prepareStatement(q); // create a statement
				pstmt.setString(1, ss); // set input parameter 1
				pstmt.executeUpdate(); // execute insert statement
				count++;
			}		
		} catch( SQLException se ) {
			System.out.println ("SQLError: " + se.getMessage ()
			+ " code: " + se.getErrorCode ());
		} catch( Exception e ) { 
			e.printStackTrace(); 
		} finally {
			// Close Connection and Statements
			try { if (pstmt != null) pstmt.close(); } catch (Exception e) {};
		    try { if (stmt != null) stmt.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
		}
		return count;
	}
}
