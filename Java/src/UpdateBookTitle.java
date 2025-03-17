import java.sql.*;

public class UpdateBookTitle {
    private static final String URL = "jdbc:sqlite:C:/Users/david/Documents/Database_assignment/Booktracker/db/Tracker1.db";

    // Método para actualizar el título de un libro
    public void updateBookTitle(int userId, String oldTitle, String newTitle) {
        String sql = "UPDATE ReadingHabit SET book_title = ? WHERE userID = ? AND book_title = ?";

        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newTitle);
            pstmt.setInt(2, userId);
            pstmt.setString(3, oldTitle);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book title updated successfully.");
            } else {
                System.out.println("No matching record found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
