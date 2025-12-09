import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    static Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection("C:/Users/stine/Documents/DAT1/Java/ScrapYarn/src/main/resources");
        return connection;
    }

}
