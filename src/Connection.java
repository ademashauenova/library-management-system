import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost:5432/library";
        java.sql.Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionUrl, "postgres", "password");

            stmt = con.createStatement();


            rs = stmt.executeQuery("select  * from public.users");

            while (rs.next())
                System.out.println(rs.getInt("id") + "  "
                        + rs.getString("name") + "  " + rs.getString("surname"));
        }
        catch (Exception e) {
            System.out.println("Exception occurred!");
        } finally {

            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Exception occurred!");
            }
        }

        System.out.println("Finished!");

    }

}
