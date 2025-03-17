import java.sql.*;

public class addUser {

    private static final String URL = "jdbc:sqlite:C:/Users/david/Documents/Database_assignment/Booktracker/db/Tracker1.db";

    // Método para añadir un nuevo usuario con edad y género
    public void addNewUser(int age, String gender) {
        // La consulta SQL para insertar un usuario con género
        String sql = "INSERT INTO User (age, gender) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Asignar los valores de edad y género a los parámetros de la consulta SQL
            pstmt.setInt(1, age);
            pstmt.setString(2, gender);

            // Ejecutar la consulta para insertar el usuario
            pstmt.executeUpdate();

            System.out.println("User added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
