import util.TextUI;
import java.awt.*;
import java.util.ArrayList;

public class StartMenu {

    TextUI ui = new TextUI();
    DBInquiries db = new DBInquiries();
    ArrayList<Pattern> knitOrCrochet = new ArrayList<>();
    ArrayList<Pattern> amountOfYarn = new ArrayList<>();
    ArrayList<Pattern> level = new ArrayList<>();
    ArrayList<Pattern> allPatterns = db.getAllPatterns();


    public void welcomeMessage() {
        ui.displayMessage("Hi! Welcome to ScrapYarn where nothing goes to waste.\n");
    }

    public void startSession() {
        chooseKnitOrCrochet();
        chooseYarnAmount();
        chooseLevel();
        printOptions();

        Pattern selectedPattern;

        if (level.size() > 1) {
            selectedPattern = selectPattern();
        } else {
            selectedPattern = level.get(0);
        }

        askToOpenPdf(selectedPattern);
    }

    //Beder brugeren om at vælge mellem strik og hækling.
    public ArrayList<Pattern> chooseKnitOrCrochet() {
        int input = ui.promptNumber("What would you like to do today? " +
                "\n1. Knit" +
                "\n2. Crochet");

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
            ui.displayMessage("Invalid input. Please try again.");
            return chooseKnitOrCrochet();
        }
        return knitOrCrochet;
    }

    //Beder brugeren om at indtaste garnmængde angivet i antal gram.
    public ArrayList<Pattern> chooseYarnAmount() {
        int input = ui.promptNumber("How many grams of yarn do you have? Enter whole numbers only.");
        for (Pattern p : knitOrCrochet) {
            if (input >= p.getYarnAmount()) {
                amountOfYarn.add(p);
            }
        }
            if (amountOfYarn.isEmpty()) {
                System.out.println("I'm sorry, I don't have any patterns that match your criteria.\n");
                tryAgain();
            }
        return amountOfYarn;
    }

    //Beder brugeren om at vælge sværhedsgrad.
    public ArrayList<Pattern> chooseLevel() {
        int input = ui.promptNumber
                ("What level would you like your suggested pattern to be?" +
                "\n1. Beginner" +
                "\n2. Intermediate" +
                "\n3. Advanced");

        if (input == 1) {
            for (Pattern p : amountOfYarn) {
                if (p.getLevel().equalsIgnoreCase("beginner")) {
                    level.add(p);
                }
            }
        } else if (input == 2) {
            for (Pattern p : amountOfYarn) {
                if (p.getLevel().equalsIgnoreCase("intermediate")) {
                    level.add(p);
                }
            }
        } else if (input == 3) {
            for (Pattern p : amountOfYarn) {
                if (p.getLevel().equalsIgnoreCase("advanced")) {
                    level.add(p);
                }
            }
        } else {
            ui.displayMessage("Invalid input. Please try again.");
            return chooseLevel();
        }
        return level;
    }

    public void printOptions() {
        for (Pattern p : level) {
            System.out.println(p);
        }
    }

    //Beder brugeren om at vælge en opskrift.
    public Pattern selectPattern() {
        int input = ui.promptNumber("Please enter the ID of the pattern you have selected.");

        for (Pattern p : level) {
            if (p.getId() == input) {
                return p;
            }
        }
        ui.displayMessage("Invalid input. Please try again.");
        return selectPattern();
    }

    //------Spørger brugeren, om man vil prøve igen (hvis man ikke er tilfreds med de foreslåede opskrifter).------
    public void tryAgain() {
        int input = ui.promptNumber("Would you like to try again?\n1.Yes \n2.No");
        if (input == 1) {
            startSession();
        } else if (input == 2) {
            endSession();
        } else {
            ui.displayMessage("Invalid input. Please try again.");
            tryAgain();
        }
    }

    //------Metode til at åbne pdf som valgmulighed------
    public void askToOpenPdf(Pattern pattern) {
        int input = ui.promptNumber("Would you like to open the pdf for the pattern?" +
                        "\n1.Yes" +
                        "\n2.No");
        if (input == 1) {
            OpenPdf.openPdfByPath(pattern.getPathtopdf());
        } else {
            ui.displayMessage("You chose to not open PDF\n");
            tryAgain();
        }
    }

    public void endSession() {
        ui.displayMessage("ScrapYarn is now closing. Have a scrappy day! :)");
    }
}
