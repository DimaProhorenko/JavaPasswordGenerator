package pg;
import java.lang.StringBuilder;
import java.util.Scanner;
import java.util.Random;

public class Generator {
	private Random random = new Random();
	String alphabet = "";
	private String passwordName = "default";
	private int passwordLength = 16;
	private boolean[] passwordOptions = {true, false, false, false};
	private Scanner scanner;
	
	public Generator(Scanner scanner) {
		this.scanner = scanner;
		
	}
	
	public String generate() {
		passwordOptions = getPasswordOptions();
		alphabet = new Alphabet(passwordOptions[0], passwordOptions[1], passwordOptions[2], passwordOptions[3]).getAlphabet();
		getPasswordNameFromUser();
		String password = generatePassword();
		savePassword(password);
		return password;
	}
	
	public void savePassword(String password) {
		Utils.appendToFile(Constants.PASSWORD_FILE_LOCATION, passwordName, password);
	}
	
	public String retrievePassword() {
		return retrievePassword(passwordName);
	}
	
	public String retrievePassword(String name) {
		return Utils.retrieveFromFile(Constants.PASSWORD_FILE_LOCATION, name);
	}
	
	public String getPasswordNameFromUser() {
		System.out.println("Enter unique password name: ");
		passwordName = scanner.nextLine();
		return passwordName;
	}
	
	public boolean[] getPasswordOptions() {
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
			String input = scanner.nextLine();
			if (input.equals("yes") || input.equals("no")) {
				passwordOptions[counter] = Utils.optionInputToBoolean(input);
				counter++;
			}
			if (counter == passwordOptions.length) optionsReady = true;
		} while(!optionsReady);
		
		return passwordOptions;
	}
	
	public String generatePassword() {
		return generatePassword(passwordLength);
	}
	
	public String generatePassword(int length) {
		StringBuilder password = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length() - 1);
			password.append(alphabet.charAt(index));
		}
		
		return password.toString();
	}
}
