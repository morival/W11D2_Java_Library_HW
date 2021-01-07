import java.util.ArrayList;

public class Borrower {
    private ArrayList<Book> borrowersCollection;

    public Borrower() {
        this.borrowersCollection = new ArrayList<Book>();
    }

    public int borrowersCollectionCount() {
        return this.borrowersCollection.size();
    }

    public void borrowBook(Book book) {
        this.borrowersCollection.add(book);
    }

    public Book returnBook() {
        Book returnedBook = null;
        if(this.borrowersCollectionCount()> 0) {
            returnedBook = this.borrowersCollection.remove(0);
        }
        return returnedBook;

    }
}
