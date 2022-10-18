package textEditor;

import java.util.Scanner;

public class UserInputFunctions {
	private static Scanner input = new Scanner(System.in);
	/** Function to show a message and get a input typed by the user in String type
	 * Only accepting when user type something
	 * @param String (Message to show to user)
	 * @return String (Input typed by the user)**/
	public static String getUserStringInput(String textToShow) {
		System.out.print(textToShow);
		String userString = input.nextLine();
		while (userString.isEmpty()) {
			System.out.println("Please type something to continue: ");
			userString = input.nextLine();
		}
		System.out.println();
		return userString;
	}
	
	/** Function to show a message and get a input typed by the user in Int type
	 * Only accepting when user type a Integer number between the minimal and max value
	 * @param String (Message to show to user)
	 * @param int (Minimal value that will be accepted)
	 * @param int (Max value that will be accepted)
	 * @return String (Input typed by the user)**/
	public static int getUserIntInput(String textToShow, int minimalValue, int maxValue) {
		int userInt = 0;
		boolean checkValidation = true;
		while (checkValidation) {
			try {
				System.out.print(textToShow);
				String userInput = input.nextLine();
				userInt = Integer.parseInt(userInput);
				if (userInt >= minimalValue && userInt <= maxValue) {
					checkValidation = false;					
				} else {
					System.out.println("Only type numbers that have a option");
				}
			} catch (Exception e) {
				System.out.println("Only type numbers please");
			}
		}
	input.close();
	return userInt;
	}
	
}
