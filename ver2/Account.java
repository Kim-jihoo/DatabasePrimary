package Restaurant;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Account extends Conn {

    public void insertUser(String id, String password) {
        try {
            String sql = "INSERT INTO users (id, pw) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, password);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("New user inserted successfully!");
            } else {
                System.out.println("Failed to insert user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.JdbcConn();

        // Usage example: Insert a new user
        account.insertUser("john123", "pass123");
    }
}
