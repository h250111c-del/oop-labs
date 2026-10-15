import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class RemoveDuplicate {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList(
                "Tendai", "Alice", "Rudo", "Alice", "Brian",
                "Tendai", "Chipo", "Rudo", "Alice"
        ));

        System.out.println("Original list: " + names);
        System.out.println("Original size: " + names.size());

        // 1. HashSet: removes duplicates, order NOT guaranteed
        Set<String> hashSet = new HashSet<>(names);
        System.out.println("\nHashSet:        " + hashSet);

        // 2. LinkedHashSet: removes duplicates, keeps ORIGINAL order
        Set<String> linkedSet = new LinkedHashSet<>(names);
        System.out.println("LinkedHashSet:  " + linkedSet);

        // 3. TreeSet: removes duplicates, SORTED alphabetically
        Set<String> treeSet = new TreeSet<>(names);
        System.out.println("TreeSet:        " + treeSet);

        // Convert back to a list if a List is needed
        List<String> unique = new ArrayList<>(linkedSet);
        System.out.println("\nUnique list: " + unique);
        System.out.println("Unique size: " + unique.size());
        System.out.println("Duplicates removed: " + (names.size() - unique.size()));
    }
}