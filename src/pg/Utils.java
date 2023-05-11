package pg;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class Utils {
	public static boolean optionInputToBoolean(String input) {
		return input.equals("yes") ? true : false;
	}
	
	public static void appendToFile(String location, String name, String content) {
		try {
			String newLine = "\n";
			File file = new File(location);
			if (!file.exists()) {
				file.createNewFile();
				newLine = "";
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(String.format("%s%s%s%s", newLine, name, Constants.DELIMITER, content));
			bw.close();
		} catch(IOException e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public static String retrieveFromFile(String location, String name) {
		String line = null;
		String result = "";
		try {
			File file = new File(location);
			
			if (file.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while ((line = br.readLine()) != null) {
					if (line.contains(name)) {
						result += line;
					}
				}
			}
		} catch(IOException e) {
			System.out.println(e.getStackTrace());
		}
		
		return result.split(Constants.DELIMITER)[2];
	}
	
}
