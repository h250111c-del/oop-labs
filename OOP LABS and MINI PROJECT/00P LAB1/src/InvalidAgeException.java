import java.util.InputMismatchException;
import java.util.Scanner;

// InvalidAgeException.java
public class InvalidAgeException extends Exception {   // extends Exception = checked
    private final int age;

    public InvalidAgeException(int age) {
        super("Invalid age: " + age + ". Age must be between 0 and 120.");
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}



class AgeValidator {

    // "throws" is mandatory because the exception is checked
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException(age);
        }
        System.out.println("Age " + age + " is valid.");
    }

    public static void main(String[] args) {
        int[] testAges = {25, 0, 120, -5, 150};

        for (int age : testAges) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Caught: " + e.getMessage());
            }
        }

        // Interactive version
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("\nEnter your age: ");
            int age = sc.nextInt();
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Rejected value: " + e.getAge());
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Please enter a whole number.");
        } finally {
            sc.close();
        }
    }
}
