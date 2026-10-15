import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.*;

public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();

    public void addItem(LibraryItem item) { items.put(item.getId(), item); }
    public void addMember(Member m) { members.put(m.getId(), m); }

    public void borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member m = members.get(memberId);
        LibraryItem i = items.get(itemId);
        if (m == null) throw new IllegalArgumentException("No member " + memberId);
        if (i == null) throw new IllegalArgumentException("No item " + itemId);
        i.borrow(m);
    }

    public void giveBack(String itemId) {
        LibraryItem i = items.get(itemId);
        if (i == null) throw new IllegalArgumentException("No item " + itemId);
        i.giveBack();
    }
    public void save(Path file) throws IOException {
        List<String> lines = new ArrayList<>();
        for (LibraryItem i : items.values())
            lines.add(String.join(",", i.getClass().getSimpleName(),
                    i.getId(), i.getTitle(), String.valueOf(i.isAvailable())));
        Files.write(file, lines);
    }

    public void load(Path file) throws IOException {
        if (!Files.exists(file)) return;
        for (String line : Files.readAllLines(file)) {
            String[] p = line.split(",");
            LibraryItem item = p[0].equals("Book") ? new Book(p[1], p[2]) : new Dvd(p[1], p[2]);
            item.setAvailable(Boolean.parseBoolean(p[3]));
            items.put(item.getId(), item);
        }
    }

    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .collect(Collectors.toList());
    }
    public List<Loan> overdueLoans() {
        List<Loan> result = new ArrayList<>();
        for (Member m : members.values())
            for (Loan l : m.getLoans())
                if (l.isOverdue()) result.add(l);
        return result;
    }


    public Map<String, LibraryItem> getItems() { return items; }
    public Map<String, Member> getMembers() { return members; }
}