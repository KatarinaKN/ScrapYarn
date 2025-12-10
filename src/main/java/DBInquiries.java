import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBInquiries {

    private String url;

    public DBInquiries (String url){
        this.url = url;
    }


    public List<String> getAlbumsByYear(int year){
        List<String> albums = new ArrayList<>();
        String sql = "SELECT title FROM Albums WHERE releaseyear = " + year;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                String title = resultSet.getString("title");
                albums.add(title);
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return albums;
    }
}
