import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBook {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
        String username = "root";
        String password = "root";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO books (title, author) values(?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "Effective Java Programming");
            stmt.setString(2, "Narendra Modi");
            int rows = stmt.executeUpdate();
            System.out.println(rows + " row inserted");
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
