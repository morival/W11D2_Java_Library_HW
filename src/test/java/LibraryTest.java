import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library library;
    private Book book;
    private Book book1;
    private Book book2;
    private Borrower borrower;

    @Before
    public void setUp() {
        library = new Library(3);
        book = new Book("Flight", "Olga Tokarczyk", "Novel");
        book1 = new Book("Becoming Supernatural", "Joe Dispenza", "Self-help book");
        book2 = new Book("The Wind-Up Bird Chronicle", "Haruki Murakami", "Novel");
        borrower = new Borrower();
        borrower.returnBook();
    }

    @Test
    public void ifLibraryIsEmpty() {
        assertEquals(0, library.countBooks());
    }

    @Test
    public void canAddBookToLibrary() {
        library.addBook(book1);
        assertEquals(1, library.countBooks());
    }

    @Test
    public void canAddWhileSpaceInLibrary() {
        library.addBook(book1);
        borrower.returnBook();
        assertEquals(1, library.countBooks());
        assertEquals(0, borrower.borrowersCollectionCount());
    }

    @Test
    public void ifExceedsCapacity() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(3, library.countBooks());
    }

    @Test
    public void canRecoverBookFromBorrower() {
        borrower.borrowBook(book1);
        library.retrieveFromBorrower(borrower);
        assertEquals(1, library.countBooks());
        assertEquals(0, borrower.borrowersCollectionCount());
    }

    @Test
    public void canLendBookToBorrower() {
        library.addBook(book1);
        library.addBook(book2);
        library.lendBook(book, borrower);
        assertEquals(1, library.countBooks());
        assertEquals(1, borrower.borrowersCollectionCount());
    }
}
