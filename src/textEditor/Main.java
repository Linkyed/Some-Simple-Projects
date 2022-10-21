package textEditor;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to my text editor script, thanks for using it and let's start: ");
		String text = UserInputFunctions.getUserStringInput("Type the text that you want to edit: ");
		System.out.print("Now choose one option bellow:\n[1] All text in Upper Case\n[2] All text in Lower Case\n[3] Only first phrase letter in Upper Case\n" +
				"[4] All first letter in Upper Case\n[5] Search for a word");
		int choose = UserInputFunctions.getUserIntInput("Type the number to choose the option: ", 1, 5);
		
		if (choose == 1) {
			text = text.toUpperCase();
			System.out.println("\nYour text has been edited successfully!\n");
			System.out.println("Now it looks like this: " + text);
		} else if (choose == 2) {
			text = text.toLowerCase();
			System.out.println("\nYour text has been edited successfully!\n");
			System.out.println("Now it looks like this: " + text);
		} else if (choose == 3) {
			String[] phrases = text.split("\\.");
			String newPhrase = "";
			for (String phrase: phrases) {
				newPhrase += phrase.strip().substring(0, 1).toUpperCase() + phrase.strip().substring(1) + ". ";
			}
			text = newPhrase;
			System.out.println("\nYour text has been edited successfully!\n");
			System.out.println("Now it looks like this: " + text);
		} else if (choose == 4){
			String[] phrases = text.split(" ");
			String newPhrase = "";
			for (String phrase: phrases) {
				if (phrase.length() > 0) {
					newPhrase += phrase.strip().substring(0, 1).toUpperCase() + phrase.strip().substring(1).toLowerCase() + " ";					
				}
			}
			text = newPhrase;
			System.out.println("\nYour text has been edited successfully!\n");
			System.out.println("Now it looks like this: " + text);
		} else if (choose == 5) {
			String word = UserInputFunctions.getUserStringInput("Type the word that you want to search: ");
			String[] textSplited = text.split(" ");
			int wordCounter = 0;
			if (text.contains(word)) {
				System.out.println("\nThe word that was searched is marked between parentheses below:");
				for (String compareWord: textSplited) {
					if (compareWord.equals(word)) {
						wordCounter++;
						System.out.print("(" + word + ") ");
					} else {
						System.out.print(compareWord + " ");
					}
				}
				System.out.println();
			}
			if(wordCounter == 0) {
				System.out.println("\nThe word " + word + " can not be found in the text, try another one!\n");
			} else {
				System.out.println("The word " + word + " was found " + wordCounter + " times!");
			}
		}
		
		
	}
}