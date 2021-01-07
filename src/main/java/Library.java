import java.util.ArrayList;

public class Library {
    private ArrayList<Book> bookCollection;
    private int stockCapacity;


    public Library(int stockCapacity) {
        this.stockCapacity = stockCapacity;
        this.bookCollection = new ArrayList<Book>();
    }

    public int countBooks() {
        return this.bookCollection.size();
    }

    public void addBook(Book book) {
        if (this.stockCapacity > countBooks()) {
            this.bookCollection.add(book);
        }
    }

    public void retrieveFromBorrower(Borrower borrower) {
        if (this.stockCapacity > countBooks() && borrower.borrowersCollectionCount() > 0) {
            Book removedFromBorrowersCollection = borrower.returnBook();
            this.addBook(removedFromBorrowersCollection);
        }
    }

    public void lendBook(Book book, Borrower borrower) {
        for (Book libraryBook:
             bookCollection) {
            Book lentBook = null;
            if (libraryBook == book) {
                lentBook = libraryBook;
            }
            bookCollection.remove(book);
            borrower.borrowBook(lentBook);
        }
    }


}
