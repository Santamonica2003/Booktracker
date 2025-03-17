import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de la base de datos SQLite
    private static final String DATABASE_URL = "jdbc:sqlite:C:/Users/david/Documents/Database_assignment/Booktracker/db/Tracker1.db";

    // Método para establecer la conexión
    public static Connection connect() {
        Connection connection = null;
        try {
            // Cargar el driver JDBC de SQLite
            Class.forName("org.sqlite.JDBC");

            // Intentar establecer la conexión
            connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Conexión exitosa con la base de datos SQLite.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: El driver JDBC no se encontró.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
