import java.time.LocalDate;

public class Loan {
    private final LibraryItem item;
    private final Member member;
    private final LocalDate dueDate;

    public Loan(LibraryItem item, Member member) {
        if (item == null || member == null)
            throw new IllegalArgumentException("Item and member required");
        this.item = item;
        this.member = member;
        this.dueDate = LocalDate.now().minusDays(1);
    }

    public LibraryItem getItem() { return item; }
    public Member getMember() { return member; }
    public LocalDate getDueDate() { return dueDate; }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return item.getTitle() + " due " + dueDate;
    }
}