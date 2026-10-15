import java.util.Arrays;

public class BubbleSortDemo {

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        for (int pass = 0; pass < n - 1; pass++) {
            boolean swapped = false;

            for (int i = 0; i < n - 1 - pass; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {   // arr[i] is bigger, so swap
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;   // already sorted, stop early
            }
        }
    }

    public static void main(String[] args) {
        // Integer[]
        Integer[] numbers = {42, 7, 19, 88, 3, 56};
        System.out.println("Before: " + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("After:  " + Arrays.toString(numbers));

        // String[]
        String[] names = {"Tendai", "Alice", "Rudo", "Brian", "Chipo"};
        System.out.println("\nBefore: " + Arrays.toString(names));
        bubbleSort(names);
        System.out.println("After:  " + Arrays.toString(names));

        // Double[] also works, because Double implements Comparable<Double>
        Double[] decimals = {3.5, -1.2, 9.9, 0.0};
        bubbleSort(decimals);
        System.out.println("\nDoubles: " + Arrays.toString(decimals));

        // int[] primitives = {5, 2, 8};
        // bubbleSort(primitives);   // COMPILE ERROR
    }
}