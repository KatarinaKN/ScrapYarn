import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:sqlite:src/main/resources/patterns.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
    }


