import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Adding a new book...");
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.println("Borrowing a book...");
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    if (library.borrowBook(borrowTitle)) {
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Book not available.");
                    }
                    break;
                case 3:
                    System.out.println("Returning a book...");
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    if (library.returnBook(returnTitle)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Book not found or already returned.");
                    }
                    break;
                case 4:
                    System.out.println("Available Books:");
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static class Library {
        private Book[] books;
        private int bookCount;

        public Library() {
            this.books = new Book[100]; // Assuming library can hold up to 100 books
            this.bookCount = 0;
        }

        public void addBook(Book book) {
            books[bookCount] = book;
            bookCount++;
        }

        public boolean borrowBook(String title) {
            for (int i = 0; i < bookCount; i++) {
                if (books[i].getTitle().equalsIgnoreCase(title) && !books[i].isBorrowed()) {
                    books[i].setBorrowed(true);
                    return true;
                }
            }
            return false;
        }

        public boolean returnBook(String title) {
            for (int i = 0; i < bookCount; i++) {
                if (books[i].getTitle().equalsIgnoreCase(title) && books[i].isBorrowed()) {
                    books[i].setBorrowed(false);
                    return true;
                }
            }
            return false;
        }

        public void displayBooks() {
            for (int i = 0; i < bookCount; i++) {
                if (!books[i].isBorrowed()) {
                    System.out.println(books[i]);
                }
            }
        }
    }

    public static class Book {
        private String title;
        private String author;
        private boolean borrowed;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.borrowed = false;
        }

        public String getTitle() {
            return title;
        }

        public boolean isBorrowed() {
            return borrowed;
        }

        public void setBorrowed(boolean borrowed) {
            this.borrowed = borrowed;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author;
        }
    }
}
