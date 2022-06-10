import java.util.Arrays;
public class VecStringTest {
    public static void main(String[] args) {
        ComparableElemVec<String> vec = new ComparableElemVec<>();
        vec.add("Fönster");
        vec.add("Telefon");
        vec.add("Flaska");
        vec.add("Tallrik");
        vec.add("Stol");
        vec.add(9, "Last entry");
        vec.add("Högtalare");
        System.out.println("toString() test:--------------------------------------");
        System.out.println(vec);
        System.out.println("\ntoArray() test:---------------------------------------");
        System.out.println(Arrays.toString(vec.toArray()));
        System.out.println("\nsortedValues() test:----------------------------------");
        System.out.println(vec.sortedValues());

    }
}