import java.sql.*;

public class AddColumnToUserTable {

    private static final String URL = "jdbc:sqlite:C:/Users/david/Documents/Database_assignment/Booktracker/db/Tracker1.db";

    // Método para añadir la columna "Name" a la tabla User
    public void addNameColumn() {
        // Consulta SQL para agregar la nueva columna
        String sql = "ALTER TABLE User ADD COLUMN Name TEXT";

        try (Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement()) {

            // Ejecutar la consulta para agregar la columna
            stmt.executeUpdate(sql);
            System.out.println("Column 'Name' added to User table successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
