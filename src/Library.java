import java.util.Arrays;

public class Library {
    Book[] books;
    int index;

    public Library() {
        books = new Book[10];
        index = 0;
    }

    public void addBook(Book book) {
        books[index++] = book;
        System.out.println("Book " + book.getTitle() + " by " + book.getAuthor() + " added.");
    }

    public void checkOut(String name, int userId) {
        for (int i = 0; i < index; i++) {
            if (books[i].getTitle().equals(name) && books[i].getStatus()) {
                books[i].setStatus(false);
                books[i].setHandlerId(userId);
                System.out.println("Book " + books[i].getTitle() + " by " + books[i].getAuthor() + " reserved for user with ID: " + books[i].getHandlerId());
                return;
            }
        }
        System.out.println("Book not found or already reserved.");
    }

    public void checkIn(String name) {
        for (int i = 0; i < index; i++) {
            if (books[i].getTitle().equals(name) && !books[i].getStatus()) {
                books[i].setStatus(true);
                System.out.println("Book retured to library " + books[i].getTitle() + " by " + books[i].getAuthor());
                return;
            }
        }
        System.out.println("Book not found or already returned.");
    }
}
