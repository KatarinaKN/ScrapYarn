    import java.io.File;
    import java.util.ArrayList;
    import java.util.List;


    public class Main {
        public static void main(String[] args)  {

          /*  //-------ALT NEDENSTÅENDE ER TIL TEST----------
            OpenPdfTest.openPdfById(1);
            DBInquiries db = new DBInquiries();
            List<String> beginners = db.getCrochetPatternByLevel("Advanced");

           // System.out.println("Begynder-opskrifter:");
            for (String name : beginners) {
                System.out.println(name);
            }*/


            StartMenu start = new StartMenu();

            start.startSession();

            ArrayList<Pattern> level = start.chooseLevel();

            System.out.println(level);

        }
    }