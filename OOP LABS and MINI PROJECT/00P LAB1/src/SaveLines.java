import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SaveLines {
    public static void main(String[] args) {
        Path file = Paths.get("lines.txt");
        Scanner in = new Scanner(System.in);

        // WRITE: try-with-resources closes the writer automatically
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (int i = 1; i <= 5; i++) {
                System.out.print("Enter line " + i + ": ");
                writer.write(in.nextLine());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Could not write file: " + e.getMessage());
            return;
        }
        System.out.println("\nSaved to " + file.toAbsolutePath());

        // READ BACK
        System.out.println("Reading back:");
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            int n = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(n++ + ": " + line);
            }
        } catch (IOException e) {
            System.err.println("Could not read file: " + e.getMessage());
        }
    }
}
