import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/library";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    public static void createUser(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO users (id, name, surname) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, 1);
                statement.setString(2, "John");
                statement.setString(3, "Doe");

                int rowsInserted = statement.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
