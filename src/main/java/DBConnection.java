import java.sql.*;
import java.nio.file.*;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        try {
            Path path = Paths.get(DBConnection.class.getClassLoader()
                    .getResource("patterns.db").toURI());
            System.out.println("Java åbner databasefilen her: " + path.toAbsolutePath());
            return DriverManager.getConnection("jdbc:sqlite:" + path.toString());
        } catch (Exception e) {
            throw new SQLException("Kunne ikke finde databasefilen", e);
        }
    }
}
