import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection{
    public Connection conn() {
        Connection conn = null;
        String dbname = "library";
        String user = "postgres";
        String password = "OOPProject";
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, password);
            if(conn != null){
                System.out.println("Connection established");
            }
            else{
                System.out.println("Connection failed");
            }
        }
        catch(Exception e){
            System.out.println("Exception occured:" + e.getMessage());
        }
        return conn;
    }
}
