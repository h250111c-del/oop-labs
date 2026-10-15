import java.util.Scanner;

public class ArrayAccess {

    // Returns the element at the given index, or -1 if the index is invalid
    public static int getElement(int[] arr, int index) {
        try {
            return arr[index];   // throws ArrayIndexOutOfBoundsException if out of range
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: index " + index + " is out of bounds. "
                    + "Valid indexes are 0 to " + (arr.length - 1) + ".");
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Element at index 2: " + getElement(numbers, 2));
        System.out.println("Element at index 7: " + getElement(numbers, 7));
        System.out.println("Element at index -1: " + getElement(numbers, -1));
        System.out.println("Program continues normally.");
    }
}