import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookController {
    private static final String URL = "jdbc:postgresql://localhost:5432/library";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    public static void getBookByTitle(String title) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM books WHERE title = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, title);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String retrievedTitle = resultSet.getString("title");
                        String author = resultSet.getString("author");
                        boolean status = resultSet.getBoolean("status");
                        System.out.println("Book with title '" + title + "' was found:");
                        System.out.println("Title: " + retrievedTitle);
                        System.out.println("Author: " + author);
                        System.out.println("Status: " + (status ? "Available" : "Borrowed"));
                    } else {
                        System.out.println("Book with title '" + title + "' was not found.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllBooks() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM books";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                List<Book> books = new ArrayList<>();
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    books.add(new Book(title, author));
                }
                System.out.println("All books:");
                for (Book book : books) {
                    System.out.println(book);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

