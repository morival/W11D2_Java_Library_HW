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

//    public Book lendBook() {
//        Book lentBook = null;
//        if (this.countBooks()>0) {
//            lentBook = this.bookCollection.remove(0);
//             borrowBook(lentBook);
//        }
//        return lentBook;
//    }
    public void lendBook(Book book, Borrower borrower) {
        for (Book libraryBook:
             bookCollection) {
            Book lentBook = null;
            if (libraryBook == book) {
                lentBook = libraryBook;
            }
//            bookCollection.remove(lentBook);
            borrower.borrowBook(lentBook);
        }
    }


}
