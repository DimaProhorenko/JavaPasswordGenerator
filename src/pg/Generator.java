package pg;
import java.lang.StringBuilder;
import java.util.Random;

public class Generator {
	private Random random = new Random();
	String alphabet = "";
	
	public Generator() {
		alphabet = new Alphabet(true, true, true, true).getAlphabet();
	}
	
	public Generator(boolean[] options) {
		alphabet = new Alphabet(options[0], options[1], options[2], options[3]).getAlphabet();
	}
	
	public String getChars() {
		Alphabet a = new Alphabet(true, true, true, true);
		return a.getAlphabet();
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
