import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Storage {

    public static void save(Library lib) throws IOException {
        List<String> items = new ArrayList<>();
        List<String> members = new ArrayList<>();
        List<String> loans = new ArrayList<>();

        for (LibraryItem i : lib.getItems().values()) {
            String type = (i instanceof Book) ? "BOOK" : "DVD";
            items.add(type + "," + i.getId() + "," + i.getTitle());
            if (!i.isAvailable())
                loans.add(i.getId() + "," + i.getCurrentLoan().getMember().getId());
        }
        for (Member m : lib.getMembers().values())
            members.add(m.getId() + "," + m.getName());

        Files.write(Path.of("items.csv"), items);
        Files.write(Path.of("members.csv"), members);
        Files.write(Path.of("loans.csv"), loans);
    }

    public static void load(Library lib) throws IOException {
        if (Files.exists(Path.of("items.csv")))
            for (String l : Files.readAllLines(Path.of("items.csv"))) {
                if (l.isBlank()) continue;
                String[] p = l.split(",");
                lib.addItem(p[0].equals("BOOK") ? new Book(p[1], p[2]) : new Dvd(p[1], p[2]));
            }

        if (Files.exists(Path.of("members.csv")))
            for (String l : Files.readAllLines(Path.of("members.csv"))) {
                if (l.isBlank()) continue;
                String[] p = l.split(",");
                lib.addMember(new Member(p[0], p[1]));
            }

        if (Files.exists(Path.of("loans.csv")))
            for (String l : Files.readAllLines(Path.of("loans.csv"))) {
                if (l.isBlank()) continue;
                String[] p = l.split(",");
                try {
                    lib.borrow(p[1], p[0]);   // memberId, itemId
                } catch (ItemNotAvailableException | MemberLimitExceededException e) {
                    System.out.println("Could not restore loan: " + e.getMessage());
                }
            }
    }
}