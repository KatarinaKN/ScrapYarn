import util.TextUI;

import java.util.ArrayList;

public class StartMenu {

    TextUI ui = new TextUI();

    //TODO er det rigtigt, at alle vores metoder, der stiller spørgsmål, skal returnere noget?

    public void startSession(){
        ui.displayMessage("Hi! Welcome to ScrapYarn where nothing goes to waste.");
        chooseKnitOrCrochet();
        chooseLevel();
    }


    DBInquiries db = new DBInquiries();
    ArrayList<Pattern> knitOrCrochet = new ArrayList<>();
    ArrayList<Pattern> allPatterns = db.getAllPatterns();

    public ArrayList<Pattern> chooseKnitOrCrochet(){

        int input = ui.promptNumber("What would you like to do today? \nType \"1\" for knitting. \nType \"2\" for crochet.");

        if (input == 1) {
            for(Pattern p : allPatterns) {
                if (p.getCraftType().equalsIgnoreCase("knit")) {
                    knitOrCrochet.add(p);
                }
            }
        } else if (input == 2) {
            for(Pattern p : allPatterns) {
                if (p.getCraftType().equalsIgnoreCase("crochet")) {
                    knitOrCrochet.add(p);
                }
            }
        } else {
            chooseKnitOrCrochet();
        }
        return knitOrCrochet;
    }

    public ArrayList<Pattern> chooseLevel(){
        ArrayList<Pattern> level = new ArrayList<>();
        int input = ui.promptNumber("What level would you like your suggested pattern to be? \nType \"1\" for beginner. " +
                "\nType \"2\" for intermediate. \nType \"3\" for advanced.");

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
            chooseLevel();
        }
        return level;
    }

    public int amountOfYarn(){
        return 0;
    }

    public int chooseNeedleSize(){
        return 0;
    }

    public int chooseYarnType(){
        return 0;
    }

    public int chooseGauge(){
        return 0;
    }

    //public ArrayList<Pattern> showAllPatterns(){
      //  return allPatterns;
    //}

    //Spørger brugeren, om man vil prøve igen (hvis man ikke er tilfreds med de foreslåede opskrifter).
    public boolean tryAgain(){
        return true;
    }

    //Giver brugeren en tilfældig opskrift.
    //public Pattern getRandomPattern(){
      //  return ;
    //}

    //TODO: endSession er egentlig ikke super nødvendig. I Matador blev den brugt til at gemme spildata, men her gemmer vi jo ikke noget...
    public void endSession(){
        ui.displayMessage("ScrapYarn is now closing. Have a scrappy day! :)");
    }
}
