import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        // Store 10 integers
        int[] values = {42, 7, 19, 88, 3, 56, 71, 25, 90, 14};
        for (int v : values) {
            numbers.add(v);          // autoboxing: int -> Integer
        }

        System.out.println("List: " + numbers);

        // Sum
        int sum = 0;
        for (int n : numbers) {
            sum += n;                // auto-unboxing: Integer -> int
        }
        System.out.println("Sum: " + sum);

        // Maximum (manual loop)
        int max = numbers.get(0);
        for (int n : numbers) {
            if (n > max) {
                max = n;
            }
        }
        System.out.println("Maximum: " + max);

        // Reverse order (without changing the original list)
        System.out.print("Reversed: [");
        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.print(numbers.get(i));
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // Shorter alternatives using the Collections class
        System.out.println("\n--- Using Collections ---");
        System.out.println("Maximum: " + Collections.max(numbers));

        List<Integer> copy = new ArrayList<>(numbers);
        Collections.reverse(copy);   // reverses in place, so we use a copy
        System.out.println("Reversed: " + copy);
    }
}
