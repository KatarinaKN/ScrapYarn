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
        int numberInput = scanner.nextInt();
        return numberInput;
    }

    public boolean promptYesOrNo(String message) {
        displayMessage(message);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Y")) {
            return true;
        } else if (input.equalsIgnoreCase("N")) {
            return false;

        } else {
            return promptYesOrNo(message);
        }
    }

}
