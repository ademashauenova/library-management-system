import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookController {
    private DatabaseConnection dbConn;

    public BookController(DatabaseConnection dbConn) {
        this.dbConn = dbConn;
    }

    public boolean addBook(Book book) {
        Connection conn = dbConn.conn();
        if (conn == null) {
            System.out.println("Failed to connect to database.");
            return false;
        }

        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new book was added to the database.");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("SQLException occurred: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("SQLException occurred while closing the connection: " + e.getMessage());
            }
        }
        return false;
    }
}

