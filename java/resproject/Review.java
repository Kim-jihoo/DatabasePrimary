package resproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Review extends Conn{
	
	public Review() {
		JdbcConn();
	}
	
	public int Create(String user_id, String restaurant, String menu, String comment, double rate) {
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO review (user_id, restaurant, menu, comment, rate) VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, restaurant);
			pstmt.setString(3, menu);
			pstmt.setString(4, comment);
			pstmt.setDouble(5, rate);
			
			return pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}
	
	public int Drop(int id) {
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM review WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			return pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}
	
	public int Update(String user_id, int id, double rate, String comment) {
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE review SET rate=?, comment=? "
					+ "WHERE user_id=? AND id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, rate);
			pstmt.setString(2, comment);
			pstmt.setString(3, user_id);
			pstmt.setInt(4, id);
			
			return pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}

}
