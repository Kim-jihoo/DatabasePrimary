package Restaurant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Recommendation extends Conn {

    public void recommendByRate() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("평점을 입력하세요 : ");
    	double minRating = scanner.nextDouble();
        try {
            String createViewQuery = "CREATE VIEW restaurant_ratings AS " +
                    "SELECT r.name, r.area, r.category, AVG(m.rate) AS average_rate " +
                    "FROM restaurant r " +
                    "JOIN menu m ON r.name = m.restaurant " +
                    "GROUP BY r.name, r.area, r.category " +
                    "HAVING AVG(m.rate) > ?";
            PreparedStatement createViewStatement = conn.prepareStatement(createViewQuery);
            createViewStatement.setDouble(1, minRating);
            createViewStatement.executeUpdate();

            String selectQuery = "SELECT * FROM restaurant_ratings";
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            System.out.println("평점이 " + minRating+" 이상인 맛집은 다음과 같습니다" + ":");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String area = resultSet.getString("area");
                String category = resultSet.getString("category");
                double averageRating = resultSet.getDouble("average_rate");

                System.out.println("Restaurant: " + name);
                System.out.println("Area: " + area);
                System.out.println("Category: " + category);
                System.out.println("Average Rating: " + averageRating);
                System.out.println("----------------------");
            }

            // Drop the view 
            String dropViewQuery = "DROP VIEW IF EXISTS restaurant_ratings";
            PreparedStatement dropViewStatement = conn.prepareStatement(dropViewQuery);
            dropViewStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void recommendByPrice() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("가격을 입력하세요 : ");
    	int maxPrice = scanner.nextInt();
        try {
            // Create a view with affordable menus
            String createViewQuery = "CREATE VIEW affordable_menu AS " +
                    "SELECT m.restaurant, m.name AS menu, m.price, r.rate " +
                    "FROM menu m " +
                    "JOIN review r ON m.restaurant = r.restaurant AND m.name = r.menu " +
                    "WHERE m.price < ?";
            PreparedStatement createViewStatement = conn.prepareStatement(createViewQuery);
            createViewStatement.setInt(1, maxPrice);
            createViewStatement.executeUpdate();

            String selectQuery = "SELECT * FROM affordable_menu";
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            // 결과화면
            System.out.println("가격이 " + maxPrice+" 이하인 맛집은 다음과 같습니다" + ":");
            while (resultSet.next()) {
                String restaurant = resultSet.getString("restaurant");
                String menu = resultSet.getString("menu");
                int price = resultSet.getInt("price");
                double rate = resultSet.getDouble("rate");

                System.out.println("Restaurant: " + restaurant);
                System.out.println("Menu: " + menu);
                System.out.println("Price: " + price);
                System.out.println("Rate: " + rate);
                System.out.println("----------------------");
            }

            // Drop the view 
            String dropViewQuery = "DROP VIEW IF EXISTS affordable_menu";
            PreparedStatement dropViewStatement = conn.prepareStatement(dropViewQuery);
            dropViewStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void recommendByArea() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("지역을 영어로 입력하세요 : ");
    	String area = scanner.next();
        try {
            String selectQuery = "SELECT * FROM restaurant WHERE area = ?";
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            selectStatement.setString(1, area);
            ResultSet resultSet = selectStatement.executeQuery();

            //결과화면
            System.out.println("Restaurants in " + area + ":");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");

                System.out.println("Restaurant: " + name);
                System.out.println("Category: " + category);
                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Recommendation recommendation = new Recommendation();
        recommendation.JdbcConn();

        // Example usage: Recommend restaurants by rate
        recommendation.recommendByRate();

        // Example usage: Recommend restaurants by price
        recommendation.recommendByPrice();

        // Example usage: Recommend restaurants by area
        recommendation.recommendByArea();
    }
}
