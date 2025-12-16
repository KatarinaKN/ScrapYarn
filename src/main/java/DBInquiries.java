import java.sql.*;
import java.util.ArrayList;

public class DBInquiries {

    public ArrayList<Pattern> getAllPatterns() {
        ArrayList<Pattern> allPatterns = new ArrayList<>();
        String sql = "SELECT id, Name, Crafttype, Level, Yarnamount, Needlesize, Gauge, Yarntype, Category, pathtopdf FROM pattern";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("Name");
                String craftType = resultSet.getString("Crafttype");
                String level = resultSet.getString("Level");
                int yarnAmount = resultSet.getInt("Yarnamount");
                double needleSize = resultSet.getDouble("Needlesize");
                String gauge = resultSet.getString("Gauge");
                String yarnType = resultSet.getString("Yarntype");
                String category = resultSet.getString("Category");
                String pathtopdf = resultSet.getString("pathtopdf");

                Pattern p = new Pattern(id, name, craftType, level, yarnAmount, needleSize, gauge, yarnType, category, pathtopdf);
                allPatterns.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Fejl i adgang til database");
            System.out.println(e.getMessage());
        }
        return allPatterns;
    }
}
