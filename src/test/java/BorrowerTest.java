import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    private Borrower borrower;
    private Book book;
    private Book book2;
    private Library library;

    @Before
    public void before(){
        library = new Library("Motherwell Library", 10);
        borrower = new Borrower("Harry Houdini");
        book = new Book("1984", "George Orwell", "Dystopian Fiction");
        book2 = new Book("The Subtle Art Of Not Giving A F*ck", "Mark Manson", "Self Help");
    }

    @Test
    public void hasName(){
        assertEquals("Harry Houdini", borrower.getName());
    }

    @Test
    public void hasNoBooksAtStart(){
        assertEquals(0, borrower.noOfBooks());
    }

    @Test
    public void canAddBook(){
        borrower.addBook(book);
        assertEquals(1, borrower.noOfBooks());
    }

    @Test
    public void checkThatBookIsInCollection(){
        borrower.addBook(book);
        assertEquals(true, borrower.isBookInCollection(book));
    }

    @Test
    public void checkThatBookIsNotInCollection(){
        borrower.addBook(book);
        assertEquals(false, borrower.isBookInCollection(book2));
    }

    @Test
    public void canRemoveBookIfInCollection(){
        borrower.addBook(book);
        borrower.removeBook(book);
        assertEquals(0, borrower.noOfBooks());
    }

    @Test
    public void canNotRemoveBookIfNotInCollection(){
        borrower.addBook(book);
        borrower.removeBook(book2);
        assertEquals(1, borrower.noOfBooks());
    }

    @Test
    public void canBorrowBookFromLibraryIfBookInLibrary(){
        library.addBook(book);
        borrower.borrowFromLibrary(library, book);
        assertEquals(1, borrower.noOfBooks());
        assertEquals(0, library.getNoOfBooks());
    }

    @Test
    public void canNotBorrowBookFromLibraryIfBookNotInLibrary(){
        library.addBook(book);
        borrower.borrowFromLibrary(library, book2);
        assertEquals(0, borrower.noOfBooks());
        assertEquals(1, library.getNoOfBooks());
    }
}
