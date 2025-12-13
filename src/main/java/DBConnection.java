import java.sql.*;
import java.nio.file.*;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        try {
            //------Classloader er Javas ressource-finder, den indlæser DBConnection
            //------og kan også finde pdf'er, billeder osv.
            //------Den er alternativet til hardkodede stier fx C:/user/...
            //------Path er et java-interface, derfor Paths. Er en factory-metode
            Path path = Paths.get(DBConnection.class.getClassLoader()
                    //------URI = Uniform Resource  Identifier. Java skelner mellem URL og URI
                    //------URI er mere generel, hvor URL er netværksorienteret
                    .getResource("patterns.db").toURI());
            //System.out.println("Java åbner databasefilen her: " + path.toAbsolutePath());
            return DriverManager.getConnection("jdbc:sqlite:" + path.toString());
        } catch (Exception e) {
            throw new SQLException("Kunne ikke finde databasefilen", e);
        }
    }
}
