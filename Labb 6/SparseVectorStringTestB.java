import java.util.Arrays;
public class SparseVectorStringTestB {
    public static void main(String[] args) {
        ComparableElemVecMap<String> vec = new ComparableElemVecMap<>();
        vec.add("Fönster");
        vec.add("Telefon");
        vec.add("Flaska");
        vec.add("Tallrik");
        vec.add("Stol");
        vec.add("Högtalare");
        System.out.println("toString() test:--------------------------------------");
        System.out.println(vec);
        System.out.println("\ntoArray() test:---------------------------------------");
        System.out.println(Arrays.toString(vec.toArray()));
        System.out.println("\nsortedValues() test:----------------------------------");
        System.out.println(vec.sortedValues());

    }
}