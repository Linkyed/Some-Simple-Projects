package textEditor;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to my text editor script, thanks for using it and let's start: ");
		String text = UserInputFunctions.getUserStringInput("Type the text that you want to edit: ");
		
		System.out.print("Now choose one option bellow:\n[1] All text in Upper Case\n[2] All text in Lower Case\n[3] Only first phrase letter in Upper Case\n" +
				"[4] All first letter in Upper Case");
		int choose = UserInputFunctions.getUserIntInput("Type the number to choose the option: ", 1, 4);
	}


	
	
	
	
	
	
}