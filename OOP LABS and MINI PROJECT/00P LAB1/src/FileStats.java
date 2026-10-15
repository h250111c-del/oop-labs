
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FileStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        // Read five lines typed by the user
        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(sc.nextLine());
        }

        Path file = Path.of("notes.txt");   // relative path: created in the working directory

        try {
            Files.write(file, lines);                       // save all five lines to the file
            List<String> saved = Files.readAllLines(file);  // read them back

            System.out.println("--- Read back from " + file + " ---");
            for (String s : saved) {
                System.out.println(s);
            }
        } catch (IOException e) {
            // I/O can fail for reasons outside the program, so report the message
            System.out.println("File error: " + e.getMessage());
        }
        sc.close();
    }
}