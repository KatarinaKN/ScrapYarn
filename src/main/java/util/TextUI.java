package util;

import java.util.Scanner;

public class TextUI {

    private Scanner scanner = new Scanner(System.in);

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String promptText(String message) {
        displayMessage(message);  //Stil bruger et spørgsmål
        String input = scanner.nextLine(); //Placerer brugerens svar og venter på svar

        return input;
    }

    public int promptNumber(String message) {
        //------som i promptText men bruger vælger tal isf at skrive------
        displayMessage(message);
        String input = scanner.nextLine();

        //------Parser input til tal, fx vælg '1' isf for at skrive begynder-------
        int numberInput = Integer.parseInt(input);
        return numberInput;
    }

    public boolean promptYesOrNo(String message) {
        displayMessage(message);
        String input = scanner.nextLine();

        //------J for "JA" / husk at ændre hvis menu skal være engelsk------
        if (input.equalsIgnoreCase("J")) {
            return true;
        } else if (input.equalsIgnoreCase("N")) {
            return false;

        } else {
            return promptYesOrNo(message);
        }
    }

}
