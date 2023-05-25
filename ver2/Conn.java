package Restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Conn {

	Connection conn = null;
	
	public void JdbcConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/TEAMPRIMARY?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
			String uid = "testuser";
			String upw = "@gPtjsdl12";

			conn = DriverManager.getConnection(url, uid, upw);

			System.out.println("Connected to the database.");

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
