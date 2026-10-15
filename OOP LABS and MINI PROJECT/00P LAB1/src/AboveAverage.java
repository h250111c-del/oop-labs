import java.util.List;

record Student2(String name, int mark) { }

public class AboveAverage {
    public static void main(String[] args) {
        List<Student2> students = List.of(
                new Student2("Mellisa", 82),
                new Student2("Viola", 55),
                new Student2("Tapiwa", 91),
                new Student2("Lesley", 67),
                new Student2("Blessing", 74),
                new Student2("Goddy", 48));

        // Step 1: class average (orElse handles an empty list)
        double average = students.stream()
                .mapToInt(Student2::mark)
                .average()
                .orElse(0);
        System.out.printf("Class average: %.2f%n", average);

        // Step 2: filter above average, extract names, sort alphabetically
        System.out.println("Above average:");
        students.stream()
                .filter(s -> s.mark() > average)
                .map(Student2::name)
                .sorted()
                .forEach(System.out::println);
    }
}
