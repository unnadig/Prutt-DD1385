import human.Human;
public class FactoryTest {
	public static void main(String[] args) {
		Human billie = Human.create("Billie", "xxxxxx-580x");
		Human jens = Human.create("Jens", "xxxxxx-581x");
		Human anna = Human.create("Anna", "xxxxxx-582x");
		System.out.println(billie);
		System.out.println(jens);
		System.out.println(anna);
	}
}