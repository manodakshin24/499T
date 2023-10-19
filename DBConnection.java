import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection dbInstance;
    private static Connection con;

    private DBConnection() {
        // private constructor //
    }

    public static synchronized DBConnection getInstance() {
        if (dbInstance == null) {
            dbInstance = new DBConnection();
        }
        return dbInstance;
    }

    public Connection getConnection() {
        if (con == null) {
            String url = "jdbc:postgresql://127.0.0.1:26257/";
            String dbName = "bank?sslmode=disable";
            String driver = "org.postgresql.Driver";
            String userName = "testuser";
            String password = "";
            try {
                Class.forName(driver).newInstance();
                this.con = DriverManager.getConnection(url + dbName, userName, password);
            } catch (Exception ex) {
                // Log the exception or handle it appropriately
                ex.printStackTrace();
            }
        }
        return con;
    }

    // Consider adding a method to close the connection when it's no longer needed
    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            // Log the exception or handle it appropriately
            ex.printStackTrace();
        }
    }
}