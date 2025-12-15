import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OpenPdf {

    public static void openPdfById(int id) {
        String query = "SELECT pathtopdf FROM pattern WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String pdfPath = resultSet.getString("pathtopdf"); // <— Brug præcis som i DB
                File file = new File(pdfPath);

                if (!file.exists()) {
                    System.err.println("Filen findes ikke: " + file.getAbsolutePath());
                    return;
                }

                Desktop.getDesktop().open(file);
                System.out.println("Åbner PDF: " );
                //------sæt dette ind, hvis stien skal vises: + file.getAbsolutePath()
            } else {
                System.err.println("Ingen PDF fundet med id = " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
