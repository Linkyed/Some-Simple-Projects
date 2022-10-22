package textEditor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class FileManagement {
	
	/** Function to write and save a file in a determined chosen path
	 * Only accepting when user type a Integer number between the minimal and max value
	 * @param path Path where the file will be saved
	 * @param fileName Name of the file to be read
	 * @return String Text that was read in the file*/
	public static String readFile(String fileName, String path) {
		String text = "";  
		try {
		      FileReader file = new FileReader(path + "\\" + fileName.replaceAll(".txt", ""));
		      BufferedReader fileReader = new BufferedReader(file);
		      String line = fileReader.readLine();
		      
		      while (line != null) {
		        text += line + "\n";
		        line = fileReader.readLine();
		      }
		      file.close();
		      return text;
		    } catch (IOException e) {
		        return text;
		    }
	}
	/** Function to write and save a file in a determined chosen path
	 * Only accepting when user type a Integer number between the minimal and max value
	 * @param name Name of the file
	 * @param textToWrite Text that will be written
	 * @param path Path where the file will be saved
	 * @return Boolean If it was written and save it will return a true, but if not it will return false**/
	public static boolean writeFile(String name, String textToWrite, String path) {
		try {
			File file = new File(path + "\\" + name.replaceAll(".txt", ""));
			if (file.createNewFile()) {
			}
			FileWriter fileW = new FileWriter(path + "\\" + name);
			fileW.write(textToWrite);
			fileW.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
}
