package resproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	
	Connection conn = null;
	
	public void JdbcConn() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/resdb?";
			url += "useSSL=false&";
			url += "serverTimezone=UTC&";
			url += "characterEncoding=UTF-8";
			
			String uid = "admin";
			String upw = "1234";
			
			conn = DriverManager.getConnection(url, uid, upw);
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			
		} catch(SQLException e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
		}
	}
	
}
