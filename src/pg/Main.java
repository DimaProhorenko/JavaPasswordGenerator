package pg;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Generator generator = new Generator(scanner);
		String password = generator.generate();
		System.err.println(password);
		System.out.println(generator.retrievePassword("stupid"));
		
		scanner.close();
	}

}
