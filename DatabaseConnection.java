import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://defaultdb";
        String username = "root";
        String password = "";  // You can leave this empty if you're using an authentication method that doesn't involve hardcoding the password.

        //return DriverManager.getConnection(url, username, password);
        return DriverManager.getConnection(url, username, password);
    }
}