import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear objetos para interactuar con las clases
        addUser addUser = new addUser();
        ReadingHabitProvider readingHabitProvider = new ReadingHabitProvider();
        UserStatistics userStatistics = new UserStatistics();
        UpdateBookTitle updateBookTitle = new UpdateBookTitle();
        DeleteReadingHabit deleteReadingHabit = new DeleteReadingHabit();
        AddColumnToUserTable addColumnToUserTable = new AddColumnToUserTable();

        // Crear un objeto Scanner para capturar la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Mostrar el menú de opciones
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new user");
            System.out.println("2. View reading habits of a user");
            System.out.println("3. Change the title of a book");
            System.out.println("4. Delete a reading record");
            System.out.println("5. Get mean age of users");
            System.out.println("6. Get total users who have read pages from a specific book");
            System.out.println("7. Get total pages read by all users");
            System.out.println("8. Get total users who have read more than one book");
            System.out.println("9. Add 'Name' column to the User table");
            System.out.println("10. Exit");
            System.out.print("Choose an option (1-10): ");
            int choice = scanner.nextInt();

            // Opción 1: Añadir un nuevo usuario
            if (choice == 1) {
                scanner.nextLine(); // Limpiar buffer
                System.out.print("Enter user age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                System.out.print("Enter user gender: ");
                String gender = scanner.nextLine();
                addUser.addNewUser(age, gender);

                // Opción 2: Ver los hábitos de lectura de un usuario
            } else if (choice == 2) {
                System.out.print("Enter user ID to view reading habits: ");
                int userId = scanner.nextInt();
                readingHabitProvider.getReadingHabitsForUser(userId);

                // Opción 3: Cambiar el título de un libro
            } else if (choice == 3) {
                scanner.nextLine(); // Limpiar buffer
                System.out.print("Enter user ID: ");
                int userId = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                System.out.print("Enter old book title: ");
                String oldTitle = scanner.nextLine();
                System.out.print("Enter new book title: ");
                String newTitle = scanner.nextLine();
                updateBookTitle.updateBookTitle(userId, oldTitle, newTitle);

                // Opción 4: Eliminar un registro de hábitos de lectura
            } else if (choice == 4) {
                scanner.nextLine(); // Limpiar buffer
                System.out.print("Enter user ID to delete reading habit: ");
                int userId = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                System.out.print("Enter book title to delete: ");
                String bookTitle = scanner.nextLine();
                deleteReadingHabit.deleteReadingHabit(userId, bookTitle);

                // Opción 5: Calcular la edad promedio de los usuarios
            } else if (choice == 5) {
                userStatistics.getMeanAge();

                // Opción 6: Obtener el total de usuarios que han leído páginas de un libro
                // específico
            } else if (choice == 6) {
                scanner.nextLine(); // Limpiar buffer
                System.out.print("Enter book title to check: ");
                String bookTitle = scanner.nextLine();
                readingHabitProvider.getUsersWhoReadBook(bookTitle);

                // Opción 7: Obtener el total de páginas leídas por todos los usuarios
            } else if (choice == 7) {
                readingHabitProvider.getTotalPagesRead();

                // Opción 8: Obtener el total de usuarios que han leído más de un libro
            } else if (choice == 8) {
                readingHabitProvider.getTotalUsersWhoReadMoreThanOneBook();

                // Opción 9: Añadir la columna 'Name' a la tabla 'User'
            } else if (choice == 9) {
                addColumnToUserTable.addNameColumn();

                // Opción 10: Salir
            } else if (choice == 10) {
                System.out.println("Exiting program...");
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        // Cerrar el scanner
        scanner.close();
    }
}
