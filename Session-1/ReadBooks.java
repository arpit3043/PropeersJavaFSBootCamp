import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadBooks {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
        String username = "root";
        String password = "root";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM books";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getInt("id") +
                        " | " + rs.getString("title") +
                        " | " + rs.getString("author") +
                        " | " + rs.getString("status"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}