import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBInquiries {

    //TODO her skal alle forespørgselsmetoder ligge.

    //TODO getAllKnitPatterns skal ændres til getAllPatterns. Den skal lægge ALLE opskrifter
    //TODO ind i en ArrayList.

    //TODO Tag stilling til om getPatternByLevel kan undværes.


    public ArrayList<Pattern> getAllKnitPatterns() {
        ArrayList<Pattern> allKnitPatterns = new ArrayList<>();
        String sql = "SELECT * FROM pattern WHERE Crafttype = 'Knit'";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int needleSize = resultSet.getInt("Needlesize");
                String name = resultSet.getString("Name");
                allKnitPatterns.add(new Pattern(name, needleSize));
            }
        } catch (SQLException e) {
            System.out.println("Fejl i adgang til database");
            System.out.println(e.getMessage());
        }
        return allKnitPatterns;
    }

    public List<String> getCrochetPatternByLevel(String level) {
        List<String> patterns = new ArrayList<>();
        String sql = "SELECT Name FROM pattern WHERE Level = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, level);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    patterns.add(resultSet.getString("Name"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patterns;
    }
}
