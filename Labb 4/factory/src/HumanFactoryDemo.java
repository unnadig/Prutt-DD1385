import human.Human;

public class HumanFactoryDemo {
	public static void main(String[] args) {
		Human billie = Human.create("Billie", "xxxxxx-580x");
		Human jens = Human.create("Jens", "xxxxxx-581x");
		Human anna = Human.create("Anna", "xxxxxx-582x");
		System.out.println(billie);
		System.out.println(jens);
		System.out.println(anna);

		/*
		NonBinary kim = new NonBinary("Kim");
        Woman emma = new Woman("Emma");
        Man peter = new Man("Peter");
        Human eva = new Human("Eva");
        Human karl = new Human("Karl") {};
		*/
	}
}