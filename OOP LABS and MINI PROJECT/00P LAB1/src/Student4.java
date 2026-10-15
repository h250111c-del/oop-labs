import java.util.Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


// Student.java
public class Student4 implements Comparable<Student4> {
    private final String name;
    private final double marks;

    public Student4(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // Natural ordering: alphabetical by name
    @Override
    public int compareTo(Student4 other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

// MarksComparator.java


 class MarksComparator implements Comparator<Student4> {
    // Highest marks first
    @Override
    public int compare(Student4 a, Student4 b) {
        return Double.compare(b.getMarks(), a.getMarks());
    }
}

// Main.java

 class Student4Demo {
    public static void main(String[] args) {
        List<Student4> students = new ArrayList<>();
        students.add(new Student4("Tendai", 72.5));
        students.add(new Student4("Alice", 88.0));
        students.add(new Student4("Rudo", 65.0));
        students.add(new Student4("Brian", 88.0));

        // 1. Natural order (Comparable): by name
        Collections.sort(students);
        System.out.println("Sorted by name:");
        students.forEach(System.out::println);

        // 2. Custom order (Comparator): by marks, highest first
        Collections.sort(students, new MarksComparator());
        System.out.println("\nSorted by marks (descending):");
        students.forEach(System.out::println);

        // 3. Same thing using a lambda
        students.sort((a, b) -> Double.compare(a.getMarks(), b.getMarks()));
        System.out.println("\nSorted by marks (ascending, lambda):");
        students.forEach(System.out::println);
    }
}
