// Book.java
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn()   { return isbn; }
    public String getTitle()  { return title; }
    public String getAuthor() { return author; }

    // Two books are equal if they have the same ISBN
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                       // same object
        if (o == null || getClass() != o.getClass()) return false;
        Book other = (Book) o;
        return Objects.equals(isbn, other.isbn);          // compare ISBN only
    }

    // Must use the same field(s) as equals()
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN " + isbn + ")";
    }
}

// BookDemo.java
 class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book b2 = new Book("978-0134685991", "Effective Java (3rd Edition)", "J. Bloch"); // same ISBN
        Book b3 = new Book("978-0596009205", "Head First Java", "Kathy Sierra");

        // equals and hashCode
        System.out.println("b1 == b2:      " + (b1 == b2));
        System.out.println("b1.equals(b2): " + b1.equals(b2));
        System.out.println("b1.equals(b3): " + b1.equals(b3));
        System.out.println("Same hashCode: " + (b1.hashCode() == b2.hashCode()));

        // HashSet rejects duplicates
        Set<Book> library = new HashSet<>();
        System.out.println("\nAdd b1: " + library.add(b1));
        System.out.println("Add b2: " + library.add(b2));   // duplicate ISBN
        System.out.println("Add b3: " + library.add(b3));

        System.out.println("\nSet size: " + library.size());
        System.out.println("Contains new Book with same ISBN? "
                + library.contains(new Book("978-0134685991", "Anything", "Anyone")));

        System.out.println("\nBooks in library:");
        for (Book b : library) {
            System.out.println("  " + b);
        }
    }
}
