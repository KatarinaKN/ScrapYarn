import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class OpenPdf {

    public static void openPdfByPath (String path){
     try{
         File file = new File (path);
         if (!file.exists()) {
             System.out.println("File not found" + file.getAbsolutePath());
             return;
         }
         Desktop.getDesktop().open(file);
         System.out.println("Pdf opening" + file.getAbsolutePath());
     } catch (Exception e) {
         e.printStackTrace();
     }
    }

}
