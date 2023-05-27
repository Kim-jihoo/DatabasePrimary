package resproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Recommendation extends Conn {
	
	public Recommendation() {
		JdbcConn();
	}
	
	public int ByRate(double rate) {
		
		PreparedStatement vstmt = null;
		PreparedStatement sstmt = null;
		PreparedStatement pstmt = null;
		
		try {
			String view = "CREATE VIEW restaurant_ratings AS " +
                    "SELECT r.name, r.area, r.category, AVG(s.rate) AS average_rate " +
                    "FROM restaurant r " +
                    "JOIN review s ON r.name = s.restaurant " +
                    "GROUP BY r.name, r.area, r.category " +
                    "HAVING AVG(s.rate) > ?";
			vstmt = conn.prepareStatement(view);
			vstmt.setDouble(1, rate);
			vstmt.executeUpdate();
			
			String sql = "SELECT * FROM restaurant_ratings";
			sstmt = conn.prepareStatement(sql);
			ResultSet rs = sstmt.executeQuery();
			
			System.out.println("평점이 " + rate + " 이상인 식당은 다음과 같습니다.\n");
			
			System.out.printf("  %-15s   %-15s   %-15s   %-5s \n", "restaurant", "area", "category", "average rate");
			System.out.printf(" --------------------------------------------------------------------- \n");
			
			while(rs.next()) {
				String name = rs.getString("name");
                String area = rs.getString("area");
                String category = rs.getString("category");
                double average_rate = rs.getDouble("average_rate"); 
                System.out.printf("  %-15s   %-15s   %-15s   %-5.2f \n", name, area, category, average_rate);
			}
			String drop = "DROP VIEW restaurant_ratings";
			pstmt = conn.prepareStatement(drop);
			pstmt.executeUpdate();
			
			return 1;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public int ByPrice(int maxPrice) {
		
		PreparedStatement vstmt = null;
		PreparedStatement sstmt = null;
		PreparedStatement pstmt = null;
		
		try {
			String view = "CREATE VIEW affordable_menu AS " +
                    "SELECT m.restaurant, m.name AS menu, m.price, r.rate " +
                    "FROM menu m " +
                    "JOIN review r ON m.restaurant = r.restaurant AND m.name = r.menu " +
                    "WHERE m.price <= ?";
			vstmt = conn.prepareStatement(view);
			vstmt.setDouble(1, maxPrice);
			vstmt.executeUpdate();
			
			String sql = "SELECT * FROM affordable_menu";
			sstmt = conn.prepareStatement(sql);
			ResultSet rs = sstmt.executeQuery();
			
			System.out.println("가격이 " + maxPrice + " 이하인 식당은 다음과 같습니다.");
			
			System.out.printf("  %-15s   %-30s   %-10s   %-5s \n", "restaurant", "menu", "price", "rate");
			System.out.printf(" --------------------------------------------------------------------- \n");
			
			while(rs.next()) {
				String restaurant = rs.getString("restaurant");
                String menu = rs.getString("menu");
                int price = rs.getInt("price");
                double rate = rs.getDouble("rate");
                System.out.printf("  %-15s   %-30s   %-10s   %-5s \n", restaurant, menu, price, rate);
			}
			String drop = "DROP VIEW affordable_menu";
			pstmt = conn.prepareStatement(drop);
			pstmt.executeUpdate();

			return 1;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public int ByArea(String area) {
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "SELECT * FROM restaurant WHERE area = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, area);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("구역이 " + area + "인 식당은 다음과 같습니다.");
			
			System.out.printf("  %-15s   %-15s \n", "name", "category");
			System.out.printf(" ------------------------------------------ \n");
			
			while(rs.next()) {
				String name = rs.getString("name");
				String category = rs.getString("category");
				System.out.printf("  %-15s   %-15s \n", name, category);
			}
			
			return 1;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

}
