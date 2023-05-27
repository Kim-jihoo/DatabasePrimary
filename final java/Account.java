package resproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account extends Conn{
	
	public Account() {
		JdbcConn();
	}
	
	public int Create(String id, String pw) {
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into users values (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			return pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}
	
	public int Login(String id, String pw) {
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "select pw from users where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet result = pstmt.executeQuery();
			
			if (result.next()) {
				if(result.getString(1).equals(pw)) {
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


