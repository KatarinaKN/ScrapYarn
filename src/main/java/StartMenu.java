import util.TextUI;
import java.awt.*;
import java.util.ArrayList;

public class StartMenu {

    TextUI ui = new TextUI();
    DBInquiries db = new DBInquiries();
    ArrayList<Pattern> knitOrCrochet = new ArrayList<>();
    ArrayList<Pattern> allPatterns = db.getAllPatterns();


    public void startSession() {
        ui.displayMessage("Hi! Welcome to ScrapYarn where nothing goes to waste.");

        boolean running = true;
        while (running) {
            chooseKnitOrCrochet();
            ArrayList<Pattern> filterByLevel = chooseLevel();
            for (Pattern p : filterByLevel) {
                System.out.println(p);

                //-----Ryk ud hvis der er flere opskrifter?------
                askToOpenPdf(p);
            }
            running = tryAgain();
        }
        endSession();
    }

    public ArrayList<Pattern> chooseKnitOrCrochet() {

        int input = ui.promptNumber("What would you like to do today? " +
                "\n1. Knitting" +
                "\n2. Crochet"
        );

        if (input == 1) {
            for (Pattern p : allPatterns) {
                if (p.getCraftType().equalsIgnoreCase("knit")) {
                    knitOrCrochet.add(p);
                }
            }
        } else if (input == 2) {
            for (Pattern p : allPatterns) {
                if (p.getCraftType().equalsIgnoreCase("crochet")) {
                    knitOrCrochet.add(p);
                }
            }
        } else {
            ui.displayMessage("Invalid input. Please try again");
            return chooseKnitOrCrochet();
        }
        return knitOrCrochet;
    }


    public ArrayList<Pattern> chooseLevel() {
        ArrayList<Pattern> level = new ArrayList<>();
        int input = ui.promptNumber
                ("What level would you like your suggested pattern to be?" +
                " \n1. Beginner" +
                "\n2. Intermediate" +
                "\n3. Advanced");

        if (input == 1) {
            for (Pattern p : knitOrCrochet) {
                if (p.getLevel().equalsIgnoreCase("beginner")) {
                    level.add(p);
                }
            }
        } else if (input == 2) {
            for (Pattern p : knitOrCrochet) {
                if (p.getLevel().equalsIgnoreCase("intermediate")) {
                    level.add(p);
                }
            }
        } else if (input == 3) {
            for (Pattern p : knitOrCrochet) {
                if (p.getLevel().equalsIgnoreCase("advanced")) {
                    level.add(p);
                }
            }
        } else {
            ui.displayMessage("Invalid input. Please try again");
            return chooseLevel();
        }
        return level;
    }


    //------Spørger brugeren, om man vil prøve igen (hvis man ikke er tilfreds med de foreslåede opskrifter).------
    public boolean tryAgain() {
        int input = ui.promptNumber("Would you like to try again?\n1.Yes \n2.No");
        return input == 1;
    }

    //------Metode til at åbne pdf som valgmulighed------
    public void askToOpenPdf(Pattern pattern) {
        int input = ui.promptNumber(
                "Would you like to open the pdf for the pattern?" +
                        "\n1.Yes" +
                        "\n2.No"
        );
        if (input == 1) {
            OpenPdf.openPdfByPath(pattern.getPathtopdf());
        } else {
            ui.displayMessage("You chose to not open PDF");
        }
    }

    public void endSession() {
        ui.displayMessage("ScrapYarn is now closing. Have a scrappy day! :)");
    }
}
