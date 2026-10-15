import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "The cat sat on the mat. The dog sat on the log. "
                + "The cat and the dog are friends.";

        // To read from the user instead, uncomment these lines:
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter a paragraph:");
        // String paragraph = sc.nextLine();

        // 1. Count the words
        Map<String, Integer> freq = new HashMap<>();
        String[] words = paragraph.toLowerCase().split("[^a-z']+");   // split on anything that isn't a letter

        for (String w : words) {
            if (w.isEmpty()) {
                continue;                        // skip empty tokens
            }
            freq.merge(w, 1, Integer::sum);      // add 1, or start at 1 if absent
        }

        // 2. A HashMap has no order, so copy the entries into a list and sort it
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());

        entries.sort((a, b) -> {
            int cmp = Integer.compare(b.getValue(), a.getValue());   // highest count first
            if (cmp != 0) {
                return cmp;
            }
            return a.getKey().compareTo(b.getKey());                 // tie: alphabetical
        });

        // 3. Print
        System.out.println("Word frequencies (highest first):");
        for (Map.Entry<String, Integer> e : entries) {
            System.out.printf("%-10s %d%n", e.getKey(), e.getValue());
        }
        System.out.println("\nTotal words: " + words.length);
        System.out.println("Unique words: " + freq.size());
    }
}
