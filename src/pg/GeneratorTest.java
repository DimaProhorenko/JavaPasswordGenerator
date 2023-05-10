package pg;

public class GeneratorTest {
	public static void main(String[] args) {
		
		Generator g = new Generator();
		System.out.println(g.generatePassword(16));
	}
}
