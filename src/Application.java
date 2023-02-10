import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add book");
            System.out.println("2. Check out book");
            System.out.println("3. Check in book");
            System.out.println("4. Show all books");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    System.out.print("Enter title: ");
                    title = sc.nextLine();

                    library.checkOut(title);
                    break;

                case 3:
                    System.out.print("Enter title: ");
                    title = sc.nextLine();

                    library.checkIn(title);
                    break;

                case 4:
                    for(int i = 0; i < library.books.length; i++) {
                        System.out.println(library.books[i]);
                    }
                    break;

                case 5:
                    System.out.println("Quitting the program...");
                    return;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
