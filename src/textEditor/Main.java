package textEditor;

public class Main {
	public static void main(String[] args){
		System.out.println("Welcome to my text editor script, thanks for using it and let's start: ");
		//Start of the main loop
		while (true) {
			int loadFile = UserInputFunctions.getUserIntInput("[1] Load a text file\n[2] Type the text\nType what you want to do: ", 1, 2);
			String text = "";
			//Here the user can load a file with the text that he want to edit or he can type it in the console
			if (loadFile ==  1) {
				String path = UserInputFunctions.getUserStringInput("Type the path of the file: ");
				String fileName = UserInputFunctions.getUserStringInput("Type the name of the file: ");
				text = FileManagement.readFile(fileName, path);
				if (text.isEmpty()) {
					System.out.println("File can not be found!\n");
				}
			} else {
				text = UserInputFunctions.getUserStringInput("Type the text that you want to edit: ");			
			}
			
			//Here the editions/search will be done, he can chose 4 different types of edition and can search for a certain word
			if (!text.isEmpty()) {
				System.out.print("Now choose one option bellow:\n[1] All text in Upper Case\n[2] All text in Lower Case\n[3] Only first phrase letter in Upper Case\n" +
						"[4] All first letter in Upper Case\n[5] Search for a word");
				int choose = UserInputFunctions.getUserIntInput("Type the number to choose the option: ", 1, 5);
				
				if (choose == 1) {
					text = text.toUpperCase();
					System.out.println("\nYour text has been edited successfully!\n");
					System.out.println("Now it looks like this: \n" + text + "\n");
				} else if (choose == 2) {
					text = text.toLowerCase();
					System.out.println("\nYour text has been edited successfully!\n");
					System.out.println("Now it looks like this: \n" + text + "\n");
				} else if (choose == 3) {
					String[] phrases = text.split("\\.");
					String newPhrase = "";
					for (String phrase: phrases) {
						newPhrase += phrase.strip().substring(0, 1).toUpperCase() + phrase.strip().substring(1) + ". ";
					}
					text = newPhrase;
					System.out.println("\nYour text has been edited successfully!\n");
					System.out.println("Now it looks like this: \n" + text + "\n");
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
					System.out.println("Now it looks like this: \n" + text + "\n");
				} else if (choose == 5) {
					String word = UserInputFunctions.getUserStringInput("Type the word that you want to search: ");
					String[] textSplited = text.split(" ");
					int wordCounter = 0;
					if (text.toLowerCase().contains(word.toLowerCase())) {
						System.out.println("The word that was searched is marked between parentheses below:");
						for (String compareWord: textSplited) {
							if (compareWord.toLowerCase().equals(word.toLowerCase())) {
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
						System.out.println("The word -" + word + "- was found " + wordCounter + " times!\n");
					}
				}
				//Here if the user has done any edition in the text, he can save it in a .txt file, the script just need the path and the name chosen by the user
				if (choose != 5) {
					System.out.println("[1] Save the text in a file .txt\n[2] Do not save");
					int saveOption = UserInputFunctions.getUserIntInput("Type the number of one option above: ", 1, 2);
					if (saveOption == 1) {
						String name = UserInputFunctions.getUserStringInput("Type the name of the file: ");
						String path = UserInputFunctions.getUserStringInput("Type the path where the .txt will be saved: ");
						if (FileManagement.writeFile(name + ".txt", text, path)) {
							System.out.println("File saved successfully!\n");
						} else {
							System.out.println("The file can not be saved, try again!\n");
						}
					}
				}
			}
		}
	}
}