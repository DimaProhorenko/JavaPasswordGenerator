package pg;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int useLowerCase = 1;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Generator generator = new Generator(getPasswordOptions(scanner));
		String password = generator.generatePassword(16);
		Utils.appendToFile(Constants.PASSWORD_FILE_LOCATION, password);
//		System.out.println(password);
		System.err.println(password);
		
	}
	
	public static boolean[] getPasswordOptions(Scanner keyboard) {
		boolean[] options = {false, false, false, false};
		String[] messages = {
				"LowerCase letters \"abcd...\" to be used?",
				"UpperCase letters \"ABCD...\" to be used?",
				"Numbers \"1,2,3,4...\" to be used?",
				"Symbols \"!@#$\" to be used?"
		};
		boolean optionsReady = false;
		int counter = 0;
		do {
			System.out.println(messages[counter]);
			String input = keyboard.nextLine();
			if (input.equals("yes") || input.equals("no")) {
				options[counter] = Utils.optionInputToBoolean(input);
				counter++;
			}
			if (counter == options.length) optionsReady = true;
		} while(!optionsReady);
		
		return options;
	}
	
	public static void startGenerator() {
		
	}

}
