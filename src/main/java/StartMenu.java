import util.TextUI;

import java.util.ArrayList;

public class StartMenu {

    TextUI ui = new TextUI();
    DBInquiries db = new DBInquiries();
    ArrayList<Pattern> knitOrCrochet = new ArrayList<>();
    ArrayList<Pattern> allPatterns = db.getAllPatterns();

    //TODO er det rigtigt, at alle vores metoder, der stiller spørgsmål, skal returnere noget?

    public void startSession() {
        ui.displayMessage("Hi! Welcome to ScrapYarn where nothing goes to waste.");

        boolean running = true;
        while (running) {
            knitOrCrochet.clear();
            chooseKnitOrCrochet();

            ArrayList<Pattern> filterByLevel = chooseLevel();

            if (filterByLevel.isEmpty()) {
                ui.displayMessage("No patterns matched your choices");
            } else {
                for (Pattern p : filterByLevel) {
                    System.out.println(p);
                }
               // int showPdf = ui.promptNumber("Would you like to open the pdf?\n1.Yes\n2.No");

            }
            running = tryAgain();
        }
        endSession();
    }

    public ArrayList<Pattern> chooseKnitOrCrochet() {

        int input = ui.promptNumber("What would you like to do today? \nType \"1\" for knitting. \nType \"2\" for crochet.");

        knitOrCrochet.clear(); //Dette rydder listen igen, hvis du taster forkert og bliver sendt tilbage
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

//public ArrayList<Pattern> showAllPatterns(){
//  return allPatterns;
//}

//Spørger brugeren, om man vil prøve igen (hvis man ikke er tilfreds med de foreslåede opskrifter).
public boolean tryAgain() {
    int input = ui.promptNumber("Would you like to try again?\n1.Yes \n2.No");
    return input == 1;
}


//Giver brugeren en tilfældig opskrift.
//public Pattern getRandomPattern(){
//  return ;
//}

//TODO: endSession er egentlig ikke super nødvendig. I Matador blev den brugt til at gemme spildata, men her gemmer vi jo ikke noget...
public void endSession() {
    ui.displayMessage("ScrapYarn is now closing. Have a scrappy day! :)");
}
    }
