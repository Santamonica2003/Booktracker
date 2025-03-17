import java.sql.*;

public class UserStatistics {
    private static final String URL = "jdbc:sqlite:C:/Users/david/Documents/Database_assignment/Booktracker/db/Tracker1.db";

    // Método para calcular la edad promedio de los usuarios
    public void getMeanAge() {
        String sql = "SELECT AVG(age) AS mean_age FROM User";

        try (Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                double meanAge = rs.getDouble("mean_age");
                System.out.println("Mean age of users: " + meanAge);
            } else {
                System.out.println("No users found in the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
