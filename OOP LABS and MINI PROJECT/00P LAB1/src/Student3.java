import java.util.HashSet;
import java.util.Set;
// Student.java
 record Student3(String name, int age) {
}

// RecordDemo.java
 class RecordDemo {
    public static void main(String[] args) {
        Student3 s1 = new Student3("Tendai", 20);
        Student3 s2 = new Student3("Tendai", 20);
        Student3 s3 = new Student3("Rudo", 22);

        // 1. Print: toString() is generated automatically
        System.out.println(s1);
        System.out.println(s3);

        // 2. Compare: equals() compares the component values
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1 == s2:      " + (s1 == s2));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println("Same hashCode: " + (s1.hashCode() == s2.hashCode()));

        // 3. Read components: accessor methods have the same name as the component
        System.out.println("Name: " + s1.name());
        System.out.println("Age:  " + s1.age());

        // Bonus: equal records work correctly in a HashSet
        Set<Student3> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println("Set size: " + set.size());
    }
}
