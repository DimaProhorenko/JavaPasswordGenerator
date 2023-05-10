package pg;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Utils {
	public static boolean optionInputToBoolean(String input) {
		return input.equals("yes") ? true : false;
	}
	
	public static void appendToFile(String location, String content) {
		try {
			String newLine = "\n";
			File file = new File(location);
			if (!file.exists()) {
				file.createNewFile();
				newLine = "";
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(newLine + content);
			bw.close();
		} catch(IOException e) {
			System.out.println(e.getStackTrace());
		}
	}
}
