package resproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account extends Conn{
	
	String id;
	String password;
	
	public Account() {
		
	}
	
	public Account(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public int Create(String id, String password) {
		JdbcConn();
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into users values (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			return pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}
	
	public int Login(String id, String password) {
		JdbcConn();
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "select password from users where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet result = pstmt.executeQuery();
			
			if (result.next()) {
				if(result.getString(1).equals(password)) {
					return 1;
				} else {
					return 0;
				}
			}
			return -1;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return -2;
		
	}
}


