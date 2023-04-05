import java.util.Scanner;

public class Menu {

    private Bookstore bookstore;
    private Scanner scanner;

    public Menu(Bookstore bookstore) {
        this.bookstore = bookstore;
        this.scanner = new Scanner(System.in);

    }

    public void run() {
        while (true) {
            System.out.println("Welcome to the Bookstore!");
            System.out.println("1. View inventory");
            System.out.println("2. Add book to inventory");
            System.out.println("3. Sell book");
            System.out.println("4. View revenue");
            System.out.println("5. Exit");

            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    viewInventory();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    sellBook();
                    break;
                case 4:
                    viewRevenue();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        }


    }

    private void viewInventory() {
        System.out.println("Inventory");
        for (Book book : bookstore.getInventory()) {
            System.out.println(book);
        }
    }


    private void addBook() {
        String title = getStringInput("Enter book title: ");
        String author = getStringInput("Enter author name: ");
        int quantity = getIntInput("Enter quantity: ");
        double price = getDoubleInput("Enter price: ");
        Book book = new Book(title, author, quantity, price);
        bookstore.addBook(book);
        System.out.println("Book added to inventory.");
    }

    private void sellBook() {
        System.out.println("Select a book to sell:");
        int index = getBookIndex();
        if (index == -1) {
            System.out.println("Book not found!");
        } else {
            Book book = bookstore.getInventory().get(index);
            if (book.getQuantity() == 0) {
                System.out.println("Sorry, this book is out of stock!");
            } else {
                bookstore.sellBook(book);
                System.out.println("Book sold!");
            }
        }
    }


    private void viewRevenue() {
        System.out.printf("Revenue: $%.2f%n", bookstore.getRevenue());
    }

    private int getBookIndex() {
        for (int i = 0; i < bookstore.getInventory().size(); i++) {
            System.out.printf("%d. %s%n", i + 1, bookstore.getInventory().get(i));
        }
        int index = getIntInput("Enter book number: ") - 1;
        if (index < 0 || index >= bookstore.getInventory().size()) {
            return -1;
        }
        return index;
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double input = Double.parseDouble(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
}