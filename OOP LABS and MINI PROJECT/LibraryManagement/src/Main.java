import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Library lib = new Library();
        Storage.load(lib);
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 Add item | 2 Register member | 3 Borrow");
            System.out.println("4 Return | 5 Search | 6 Overdue | 0 Exit");
            String choice = in.nextLine();
            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Type (book/dvd): ");
                        String type = in.nextLine();
                        System.out.print("Id: ");
                        String id = in.nextLine();
                        System.out.print("Title: ");
                        String title = in.nextLine();
                        lib.addItem(type.equalsIgnoreCase("dvd")
                                ? new Dvd(id, title) : new Book(id, title));
                    }
                    case "2" -> {
                        System.out.print("Member id: ");
                        String id = in.nextLine();
                        System.out.print("Name: ");
                        String name = in.nextLine();
                        lib.addMember(new Member(id, name));
                    }
                    case "3" -> {
                        System.out.print("Member id: ");
                        String m = in.nextLine();
                        System.out.print("Item id: ");
                        String i = in.nextLine();
                        lib.borrow(m, i);
                    }
                    case "4" -> {
                        System.out.print("Item id: ");
                        lib.giveBack(in.nextLine());
                    }
                    case "5" -> {
                        System.out.print("Search text: ");
                        lib.searchByTitle(in.nextLine())
                                .forEach(System.out::println);
                    }
                    case "6" -> {
                        List<Loan> late = lib.overdueLoans();
                        if (late.isEmpty()) System.out.println("No overdue items.");
                        else late.forEach(System.out::println);
                    }

                    default -> System.out.println("Pick a number from the menu.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}