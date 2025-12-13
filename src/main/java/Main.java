    import java.io.File;
    import java.util.List;


    public class Main {
        public static void main(String[] args)  {

            //-------ALT NEDENSTÅENDE ER TIL TEST----------

            OpenPdf.openPdfById(1);
            DBInquiries db = new DBInquiries();
            List<String> beginners = db.getCrochetPatternByLevel("Intermediate");

            System.out.println("Intermediate-opskrifter:");
            for (String name : beginners) {
                System.out.println(name);
            }

        }
    }