import human.*;
public class FactoryFail {
    public static void main(String[] args) {
        NonBinary kim = new NonBinary("Kim");
        Woman emma = new Woman("Emma");
        Man peter = new Man("Peter");
        Human eva = new Human("Eva");
        Human karl = new Human("Karl") {};
    }
}