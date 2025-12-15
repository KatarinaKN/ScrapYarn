import util.TextUI;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class StartMenu {

    TextUI ui = new TextUI();
    DBInquiries db = new DBInquiries();
    ArrayList<Pattern> knitOrCrochet = new ArrayList<>();
    ArrayList<Pattern> allPatterns = db.getAllPatterns();

    //TODO er det rigtigt, at alle vores metoder, der stiller spørgsmål, skal returnere noget?
    /*Nej - her er tommelfingerreglerne:
    1. Stil spørgsmål og filtrer data = returner resultat
    2. Stil spørgsmål og styr flow = returner int eller boolean
    3. Vis noget = Void / IKKE return
    */

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
                "\nType \"1\" for knitting. " +
                "\nType \"2\" for crochet."
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
        int input = ui.promptNumber("What level would you like your suggested pattern to be?" +
                " \nType \"1\" for beginner. " +
                "\nType \"2\" for intermediate. " +
                "\nType \"3\" for advanced.");

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

    public int amountOfYarn() {
        return 0;
    }

    public int chooseNeedleSize() {
        return 0;
    }

    public int chooseYarnType() {
        return 0;
    }

    public int chooseGauge() {
        return 0;
    }
    //------Flyt til PatternCatalogue? Så den klasse indeholder Arraylister/kataloger inkl. random
    /*public ArrayList<Pattern> showAllPatterns() {
        return new ArrayList<>(patterns);
    } */

    //Spørger brugeren, om man vil prøve igen (hvis man ikke er tilfreds med de foreslåede opskrifter).
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
            OpenPdfTest.openPdfByPath(pattern.getPathtopdf());
        } else {
            ui.displayMessage("You chose to not open PDF");
        }
    }


//Giver brugeren en tilfældig opskrift.
/*public Pattern getRandomPattern(){
    Random random = new random;
    int index = random.nextInt(patterns.size());
     return patterns.get(index);
}*/

    //TODO: endSession er egentlig ikke super nødvendig. I Matador blev den brugt til at gemme spildata, men her gemmer vi jo ikke noget...
    public void endSession() {
        ui.displayMessage("ScrapYarn is now closing. Have a scrappy day! :)");
    }
}
