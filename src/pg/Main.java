package pg;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Encryptor encryptor = new Encryptor();
		Generator generator = new Generator(scanner);
		
		
//		String password = generator.generate(encryptor);
//		System.err.println(password);
		System.out.println(generator.retrievePassword("facebook", encryptor));
		
		scanner.close();
	}

}
