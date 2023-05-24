package resproject;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class View extends Conn{
	
	
	public View() {
		
	}
	
	public void Restaurant() {
		JdbcConn();
		
		Statement stmt = null;
		
		System.out.println("\n식당 목록");
		
		try {
			String sql = "select * from restaurant";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				String menu = rs.getString("menu");
				String area = rs.getString("area");
				String category = rs.getString("category");
				System.out.println("name: " + name + " menu: " + menu + " area: " + area + " category: " + category);
			}
			System.out.println("");
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Menu(String restaurant) {
		JdbcConn();
		
		PreparedStatement pstmt = null;

		System.out.println("\n메뉴 목록");
		
		try {
			String sql = "select * from menu where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, restaurant);
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				System.out.println("name: " + name + " description: " + description + " price: " + price);
			}
			System.out.println("");
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Review(String userid) {
		JdbcConn();
		
		PreparedStatement pstmt = null;

		System.out.println("\n리뷰 목록");
		
		try {
			String sql = "select * from review where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				String restaurant = rs.getString("restaurant");
				String menu = rs.getString("menu");
				int rate = rs.getInt("rate");
				String comment = rs.getString("comment");
				int price = rs.getInt("price");
				System.out.println("restaurant: " + restaurant + " menu: " + menu + " rate: " + rate + " comment: " + comment + " price: " + price);
			}
			System.out.println("");

		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} 
	}
}
