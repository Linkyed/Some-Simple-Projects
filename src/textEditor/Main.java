package textEditor;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to my text editor script, thanks for using it and let's start: ");
		String text = UserInputFunctions.getUserStringInput("Type the text that you want to edit: ");
		System.out.print("Now choose one option bellow:\n[1] All text in Upper Case\n[2] All text in Lower Case\n[3] Only first phrase letter in Upper Case\n" +
				"[4] All first letter in Upper Case");
		int choose = UserInputFunctions.getUserIntInput("Type the number to choose the option: ", 1, 4);
		
		if (choose == 1) {
			text = text.toUpperCase();
		} else if (choose == 2) {
			text = text.toLowerCase();
		} else if (choose == 3) {
			String[] phrases = text.split("\\.");
			String newPhrase = "";
			for (String phrase: phrases) {
				newPhrase += phrase.strip().substring(0, 1).toUpperCase() + phrase.strip().substring(1) + ". ";
			}
			text = newPhrase;
		} else {
			String[] phrases = text.split(" ");
			String newPhrase = "";
			for (String phrase: phrases) {
				if (phrase.length() > 0) {
					newPhrase += phrase.strip().substring(0, 1).toUpperCase() + phrase.strip().substring(1).toLowerCase() + " ";					
				}
			}
			text = newPhrase;
		}
		System.out.println("\nYour text has been edited successfully!\n");
		System.out.println("Now it looks like this: " + text);
		
	}
}