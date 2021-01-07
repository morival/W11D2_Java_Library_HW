import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {
    private Borrower borrower;
    private Book book1;
    private Book book2;

    @Before
    public void setUp() {
        borrower = new Borrower();
        book1 = new Book("Becoming Supernatural", "Joe Dispenza", "Self-help book");
        book2 = new Book("The Wind-Up Bird Chronicle", "Haruki Murakami", "Novel");
    }

    @Test
    public void collectionIsEmpty() {
        assertEquals(0, borrower.borrowersCollectionCount());
    }

    @Test
    public void canBorrowBook() {
        borrower.borrowBook(book1);
        assertEquals(1, borrower.borrowersCollectionCount());
    }

    @Test
    public void canReturnBook() {
        borrower.borrowBook(book1);
        borrower.borrowBook(book2);
        borrower.returnBook();
        assertEquals(1, borrower.borrowersCollectionCount());
    }

    @Test
    public void cannotReturnBook() {
        borrower.returnBook();
        assertEquals(0, borrower.borrowersCollectionCount());
    }
}
