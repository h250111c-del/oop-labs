// Level.java
public enum Level {
    LOW, MEDIUM, HIGH
}

// Level.java
class LevelDemo{

    // Classic switch statement
    public static void printAdvice(Level level) {
        switch (level) {
            case LOW:
                System.out.println("LOW: All is calm. Carry on as normal.");
                break;
            case MEDIUM:
                System.out.println("MEDIUM: Stay alert and keep an eye on things.");
                break;
            case HIGH:
                System.out.println("HIGH: Take action now!");
                break;
        }
    }

    // Modern switch expression (Java 14+): returns a value, no break needed
    public static String adviceFor(Level level) {
        return switch (level) {
            case LOW    -> "All is calm. Carry on as normal.";
            case MEDIUM -> "Stay alert and keep an eye on things.";
            case HIGH   -> "Take action now!";
        };
    }

    public static void main(String[] args) {
        // Loop over every constant using values()
        for (Level l : Level.values()) {
            printAdvice(l);
        }

        System.out.println();

        Level current = Level.MEDIUM;
        System.out.println("Current level: " + current);
        System.out.println("Advice: " + adviceFor(current));
        System.out.println("Ordinal: " + current.ordinal());

        // Convert a String to an enum constant
        Level fromText = Level.valueOf("HIGH");
        System.out.println("From text: " + fromText);
        System.out.println("Same constant? " + (fromText == Level.HIGH));
    }
}
