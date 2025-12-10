import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBInquiries {

    private String url;

    public DBInquiries (String url){
        this.url = url;
    }
    //Database db = new Database("jdbc:sqlite:data/music.sqlite");
    //
    //        System.out.println("=== OPGAVE 1: Albums fra 1998 ===");
    //        List<String> albums1998 = db.getAlbumsByYear(1998);
    //        albums1998.forEach(System.out::println);

    public List<String> getCrochetPatternByLevel(String level){
        List<String> patterns = new ArrayList<>();
        String sql = "SELECT Name FROM pattern WHERE Level = " + level;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                String name = resultSet.getString("Name");
                patterns.add(name);
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return patterns;
    }
}
