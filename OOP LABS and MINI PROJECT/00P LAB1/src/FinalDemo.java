public class FinalDemo {

    // 1. The basic case from the exercise
    static int basic() {
        try {
            System.out.println("basic: in try");
            return 1;
        } finally {
            System.out.println("basic: in finally");
        }
    }

    // 2. finally changes the variable, but the return value was already decided
    static int primitiveCopy() {
        int x = 10;
        try {
            System.out.println("primitiveCopy: returning " + x);
            return x;
        } finally {
            x = 99;
            System.out.println("primitiveCopy: finally set x to " + x);
        }
    }

    // 3. A return inside finally overrides the earlier return (bad practice)
    @SuppressWarnings("finally")
    static int override() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    // 4. Exception thrown, caught, return in catch, finally still runs
    static int withException() {
        try {
            System.out.println("withException: about to divide");
            int r = 10 / 0;
            return r;
        } catch (ArithmeticException e) {
            System.out.println("withException: caught");
            return -1;
        } finally {
            System.out.println("withException: in finally");
        }
    }

    // 5. With an object, finally CAN change what the caller sees
    static StringBuilder mutable() {
        StringBuilder sb = new StringBuilder("Hello");
        try {
            return sb;
        } finally {
            sb.append(" World");
        }
    }

    public static void main(String[] args) {
        System.out.println("Result: " + basic());
        System.out.println();
        System.out.println("Result: " + primitiveCopy());
        System.out.println();
        System.out.println("Result: " + override());
        System.out.println();
        System.out.println("Result: " + withException());
        System.out.println();
        System.out.println("Result: " + mutable());
    }
}
