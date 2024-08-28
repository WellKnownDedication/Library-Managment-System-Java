package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnector {
    private static String url = "jdbc:mysql://localhost:3306/librarymanagmentdb";
    private static String username = "root";
    private static String password = "1111";

    public static void main(String[] args) {
        System.out.println("Connecting database ...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
