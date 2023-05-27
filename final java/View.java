package resproject;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class View extends Conn{
	
	
	public View() {
		JdbcConn();
	}
	
	public void Restaurant() {
		
		Statement stmt = null;
		
		System.out.println("\n식당 목록");
		
		try {
			String sql = "SELECT * FROM restaurant";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.printf("  %-15s   %-15s   %-15s \n", "name", "area", "category");
			System.out.printf(" --------------------------------------------------- \n");
			
			while(rs.next()) {
				String name = rs.getString("name");
				String area = rs.getString("area");
				String category = rs.getString("category");
				System.out.printf("  %-15s   %-15s   %-15s \n", name, area, category);
			}
			System.out.println("");
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Menu(String restaurant) {
		
		PreparedStatement pstmt = null;

		System.out.println("\n메뉴 목록");
		
		try {
			String sql = "SELECT * FROM menu "
					+ "WHERE restaurant=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, restaurant);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.printf("  %-5s   %-30s   %-10s \n", "id", "name", "price");
			System.out.printf(" --------------------------------------------------- \n");
			
			while(rs.next()) {
				int id = rs.getShort("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				System.out.printf("  %-5s   %-30s   %-10s \n", id, name, price);
			}
			System.out.println("");
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Review(String user_id) {
		
		PreparedStatement pstmt = null;

		System.out.println("\n리뷰 목록");
		
		try {
			String sql = "SELECT * FROM review "
					+ "WHERE user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.printf("  %-5s   %-15s   %-30s   %-15s   %-30s \n", "id", "restaurant", "menu", "rate", "comment");
			System.out.printf(" -------------------------------------------------------------------------------------------------------- \n");
			
			while(rs.next()) {
				int id = rs.getShort("id");
				String restaurant = rs.getString("restaurant");
				String menu = rs.getString("menu");
				float rate = rs.getFloat("rate");
				String comment = rs.getString("comment");
				System.out.printf("  %-5s   %-15s   %-30s   %-15s   %-30s \n", id, restaurant, menu, rate, comment);
			}
			System.out.println("");

		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public void Area() {
		
	    PreparedStatement pstmt = null;
	    
	    System.out.println("구역 별 식당 수");
	    
	    try {
	        String sql = "SELECT area, COUNT(*) AS count_of_restaurants FROM restaurant GROUP BY area";
	        pstmt = conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        
	        System.out.printf(" %-15s %-10s \n", "area", "count");
	        System.out.println("----------------------------------------------");
	        
	        while (rs.next()) {
	            String areaResult = rs.getString("area");
	            int count = rs.getInt("count_of_restaurants");
	            
	            System.out.printf(" %-15s %-10s \n", areaResult, count);
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}
}
