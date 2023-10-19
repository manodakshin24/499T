import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BulkInsertPP{
    public static void main(String[] args) {
        int N = 10000;
        int[] populatedArray = new int[N];

        for(int i = 0; i < N; i++) {
          populatedArray[i] = (int)(Math.random() * N); // Generates a random double between 0.0 (inclusive) and 1.0 (exclusive)
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            // Disable auto-commit for better performance
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO numbers (column_name) VALUES (?)")) {
              int id = 1;
                for (int value : populatedArray) {
                    preparedStatement.setInt(1, id);
                    preparedStatement.addBatch();
                    preparedStatement.setInt(2, value);
                    preparedStatement.addBatch();
                    id++;
                }

                // Execute the batch
                preparedStatement.executeBatch();

                // Commit the transaction
                connection.commit();
            } catch (SQLException e) {
                // Rollback the transaction in case of an error
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}