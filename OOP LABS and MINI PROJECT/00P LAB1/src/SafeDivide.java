import java.util.InputMismatchException;
import java.util.Scanner;

 class SafeDivideLoop {

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That is not a whole number. Try again.");
                sc.nextLine();   // discard the bad token, otherwise the loop never ends
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = readInt(sc, "Enter the first integer: ");
        int b = readInt(sc, "Enter the second integer: ");

        try {
            System.out.println(a + " / " + b + " = " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Error: cannot divide by zero.");
        }

        sc.close();
    }
}
