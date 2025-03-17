import java.sql.*;

public class ReadingHabitProvider {
    private static final String URL = "jdbc:sqlite:C:/Users/david/Documents/Database_assignment/Booktracker/db/Tracker1.db";

    // Método para obtener los hábitos de lectura de un usuario específico
    public void getReadingHabitsForUser(int userId) {
        String sql = "SELECT book_title, pages_read FROM ReadingHabit WHERE userID = ?";

        try (Connection conn = DriverManager.getConnection(URL); // Establecer la conexión
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId); // Establecer el parámetro de la consulta SQL
            ResultSet rs = pstmt.executeQuery(); // Ejecutar la consulta

            while (rs.next()) {
                String bookTitle = rs.getString("book_title");
                int pagesRead = rs.getInt("pages_read");
                System.out.println("Book: " + bookTitle + ", Pages Read: " + pagesRead);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Si ocurre un error, se muestra la traza de la excepción
        }
    }

    // Método para contar el número total de usuarios que han leído más de un libro
    public void getTotalUsersWhoReadMoreThanOneBook() {
        String sql = "SELECT COUNT(DISTINCT userID) AS total_users " +
                "FROM ReadingHabit " +
                "GROUP BY userID " +
                "HAVING COUNT(DISTINCT book_title) > 1";

        try (Connection conn = DriverManager.getConnection(URL); // Establecer la conexión
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery(); // Ejecutar la consulta

            if (rs.next()) {
                int totalUsers = rs.getInt("total_users");
                System.out.println("Total number of users who have read more than one book: " + totalUsers);
            } else {
                System.out.println("No users have read more than one book.");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Si ocurre un error, se muestra la traza de la excepción
        }
    }

    // Método para contar el número total de usuarios que han leído páginas de un
    // libro específico
    public void getUsersWhoReadBook(String bookTitle) {
        String sql = "SELECT COUNT(DISTINCT userID) AS total_users FROM ReadingHabit WHERE book_title = ?";

        try (Connection conn = DriverManager.getConnection(URL); // Establecer la conexión
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, bookTitle); // Establecer el parámetro de la consulta SQL
            ResultSet rs = pstmt.executeQuery(); // Ejecutar la consulta

            if (rs.next()) {
                int totalUsers = rs.getInt("total_users");
                System.out.println("Total users who have read the book \"" + bookTitle + "\": " + totalUsers);
            } else {
                System.out.println("No users found who have read the book \"" + bookTitle + "\".");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Si ocurre un error, se muestra la traza de la excepción
        }
    }

    // Método para obtener el total de páginas leídas por todos los usuarios
    public void getTotalPagesRead() {
        String sql = "SELECT SUM(pages_read) AS total_pages FROM ReadingHabit";

        try (Connection conn = DriverManager.getConnection(URL); // Establecer la conexión
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery(); // Ejecutar la consulta

            if (rs.next()) {
                int totalPages = rs.getInt("total_pages");
                System.out.println("Total pages read by all users: " + totalPages);
            } else {
                System.out.println("No reading data found.");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Si ocurre un error, se muestra la traza de la excepción
        }
    }
}
