import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BulkInsert {

    public static void main(String[] args) {
        int N = 10000;
        int[] populatedArray = new int[N];
        // Create an array to store random numbers
        String url = "jdbc:postgresql://127.0.0.1:26257/";
        String dbName = "bank?sslmode=disable";
        String driver = "org.postgresql.Driver";
        String userName = "testuser";
        String password = "";
        // Populate the array with random numbers
        for(int i = 0; i < N; i++) {
          populatedArray[i] = (int)(Math.random() * N); // Generates a random double between 0.0 (inclusive) and 1.0 (exclusive)
        }
        //int[] valuesToInsert = {1, 2, 3, 4, 5};  // Your array of integers
        try {
            // Establish a connection to your database
            Connection connection = DriverManager.getConnection(url + dbName, userName, password);

            // Create a PreparedStatement with the INSERT query
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO your_table_name (column_name) VALUES (?)");

            // Iterate through the array and add each value to the batch
            for (int value : populatedArray) {
                preparedStatement.setInt(1, value);
                preparedStatement.addBatch();
            }

            // Execute the batch insert
            int[] result = preparedStatement.executeBatch();

            // Commit the transaction
            connection.commit();

            // Close resources
            preparedStatement.close();
            connection.close();

            System.out.println("Rows affected: " + result.length);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}