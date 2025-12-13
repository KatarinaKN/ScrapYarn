import util.TextUI;

import java.util.ArrayList;

public class StartMenu {

    TextUI ui = new TextUI();

    //TODO er det rigtigt, at alle vores metoder, der stiller spørgsmål, skal returnere noget?

    public void startSession(){
        ui.displayMessage("Hi! Welcome to ScrapYarn where nothing goes to waste.");
        //Skal denne metode så kalde alle spørgsmålsmetoderne? Og kan vi så til sidst bruge
        //returns til at få vist en opskrift?
    }


    DBInquiries db = new DBInquiries();

    public ArrayList<Pattern> chooseKnitOrCrochet(){
        ArrayList<Pattern> knitOrCrochet = new ArrayList<>();
        ArrayList<Pattern> allPatterns = db.getAllPatterns();
        int input = ui.promptNumber("What would you like to do today? \nType \"1\" for knitting. \nType \"2\" for crochet.");

        if (input == 1) {
            for(Pattern p : allPatterns){
                if (p.getCraftType().equalsIgnoreCase("knit")) {
                    knitOrCrochet.add(p);
                }
            }
        } else if (input == 2) {
            for(Pattern p : allPatterns){
                if (p.getCraftType().equalsIgnoreCase("crochet")) {
                    knitOrCrochet.add(p);
                }
            }
        } else {
            chooseKnitOrCrochet();
        }
        return knitOrCrochet;
    }

    public int chooseLevel(){
        int level = ui.promptNumber("What level would you like your suggested pattern to be? \n Type \"1\" for beginner. " +
                "\n Type \"2\" for intermediate. \n Type \"3\" for advanced.");
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
