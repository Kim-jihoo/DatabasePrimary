package Restaurant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Review extends Conn {

    public void writeReview(String id) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("레스토랑 이름을 입력하세요: ");
        String restaurantName = scanner.nextLine();

        System.out.println("메뉴 이름을 입력하세요: ");
        String menuItem = scanner.nextLine();

        System.out.println("리뷰를 입력하세요: ");
        String comment = scanner.nextLine();

        System.out.println("평점을 입력하세요(0-5사이의 소숫점 한자리): ");
        double rating = scanner.nextDouble();

        try {
            String sql = "INSERT INTO review (user_id, restaurant, menu, comment, rate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, restaurantName);
            statement.setString(3, menuItem);
            statement.setString(4, comment);
            statement.setDouble(5, rating);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("리뷰가 정상적으로 등록되었습니다");
            } else {
                System.out.println("리뷰등록에 실패하였습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReview(String userId) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("수정할 리뷰의 id를 입력해주세요 : ");
        int reviewId = scanner.nextInt();
        scanner.nextLine(); 

        try {
            String checkSql = "SELECT * FROM review WHERE id = ? AND user_id = ?";
            PreparedStatement checkStatement = conn.prepareStatement(checkSql);
            checkStatement.setInt(1, reviewId);
            checkStatement.setString(2, userId);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {

                System.out.println("새로운 리뷰를 입력해주세요 : ");
                String newComment = scanner.nextLine();

                System.out.println("새로운 평점을 입력해주세요 (0-5사이의 소숫점 한자리수): ");
                double newRating = scanner.nextDouble();

                String updateSql = "UPDATE review SET comment = ?, rate = ? WHERE id = ?";
                PreparedStatement updateStatement = conn.prepareStatement(updateSql);
                updateStatement.setString(1, newComment);
                updateStatement.setDouble(2, newRating);
                updateStatement.setInt(3, reviewId);

                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("리뷰가 정상적으로 수정되었습니다.");
                } else {
                    System.out.println("리뷰 수정에 실패하였습니다.");
                }
            } else {
                System.out.println("리뷰를 수정할 수 없습니다. 리뷰id를 확인하세요.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Review review = new Review();
        review.JdbcConn();

        // Example usage: Write a new review
        review.writeReview("john123");

        // Example usage: Update a review
        review.updateReview("john123");
    }
}
