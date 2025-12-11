import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBInquiries {

    public List<String> getCrochetPatternByLevel(String level) {
        List<String> patterns = new ArrayList<>();
        String sql = "SELECT Name FROM pattern WHERE Level = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, level);
            try (ResultSet resultSet = stmt.executeQuery()) {
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
