package resproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Review extends Conn{
	
	String restaurant;
	String menu;
	int rate;
	String comment;
	int rev_id;
	
	public Review() {
		
	}
	
	public int Create(String userid, String restaurant, String menu, int rate, String comment) {
		JdbcConn();
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into review values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, restaurant);
			pstmt.setString(3, menu);
			pstmt.setInt(4, rate);
			pstmt.setString(5, comment);
			
			return pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}
	
	public int Drop(String userid, String restaurant, String menu) {
		JdbcConn();
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from review where userid=?, restaurant=?, menu=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, restaurant);
			pstmt.setString(3, menu);
			
			return pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}
	
	public int Update(String userid, String restaurant, String menu, int rate, String comment) {
		JdbcConn();
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update review where userid=?, restaurant=?, menu=? set rate=?, comment=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, restaurant);
			pstmt.setString(3, menu);
			pstmt.setInt(4, rate);
			pstmt.setString(5, comment);
			
			return pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}

}
