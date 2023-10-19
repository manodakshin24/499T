import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StudentCRUD{

 static Connection con = DBConnection.getInstance().getConnection();
 public static void insertStudent() throws SQLException {
  con.createStatement().execute("INSERT INTO school.student (id, name) VALUES (11, 'Deepak'), (22, 'Abhishek')");
 }

 public static void selectStudent() throws SQLException {
  ResultSet res = con.createStatement().executeQuery("SELECT id, name FROM student");
  while (res.next()) {
   System.out.printf("\tStudent %s: %s\n", res.getInt("id"), res.getString("name"));
  }
 }

 public static void createTable() throws SQLException {
  // Create the "student" table.
  con.createStatement().execute("CREATE TABLE IF NOT EXISTS student (id INT PRIMARY KEY, name varchar(30))");

 }

 public static void deleteStudent() throws SQLException {
  // Create the "student" table.
  con.createStatement().execute("delete from student where id=22");

 }

 public static void updateStudent() throws SQLException {
  // Create the "student" table.
  con.createStatement().execute("update student set name='deepak mehra' where id=11");

 }
}