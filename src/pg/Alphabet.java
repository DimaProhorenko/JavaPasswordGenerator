package pg;
import java.lang.StringBuilder;

public class Alphabet {
	private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "1234567890";
	private static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
	
	private final StringBuilder pool = new StringBuilder();
	
	
	public Alphabet(boolean upperIncluded, boolean lowerIncluded, boolean numsIncluded, boolean symbolsIncluded) {
		if (upperIncluded) pool.append(UPPERCASE_LETTERS);
		if (lowerIncluded) pool.append(LOWERCASE_LETTERS);
		if (numsIncluded) pool.append(NUMBERS);
		if (symbolsIncluded) pool.append(SYMBOLS);
	}
	
	public String getAlphabet() {
		return pool.toString();
	}
	
}
