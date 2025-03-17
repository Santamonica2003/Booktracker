import java.sql.*;

public class DeleteReadingHabit {
    private static final String URL = "jdbc:sqlite:C:/Users/david/Documents/Database_assignment/Booktracker/db/Tracker1.db";

    // Método para eliminar un registro de la tabla ReadingHabit
    public void deleteReadingHabit(int userId, String bookTitle) {
        String sql = "DELETE FROM ReadingHabit WHERE userID = ? AND book_title = ?";

        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setString(2, bookTitle);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Reading habit deleted successfully.");
            } else {
                System.out.println("No matching record found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
