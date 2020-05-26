import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book;
    private Book book2;

    @Before
    public void before(){
        book = new Book("1984", "George Orwell", "Dystopian Fiction");
        book2 = new Book("The Subtle Art Of Not Giving A F*ck", "Mark Manson", "Self Help");
        library = new Library("Motherwell Library", 10);
    }

    @Test
    public void libraryHasName(){
        assertEquals("Motherwell Library", library.getName());
    }

    @Test
    public void hasCapacity(){
        assertEquals(10, library.getCapacity());
    }

    @Test
    public void libraryStartsWithNoBooks(){
        assertEquals(0, library.getNoOfBooks());
    }

    @Test
    public void canAddBookToLibrary(){
        library.addBook(book);
        assertEquals(1, library.getNoOfBooks());
    }

    @Test
    public void bookIsInLibrary(){
        library.addBook(book);
        assertEquals(true, library.isBookInLibrary(book));
    }

    @Test
    public void bookIsNotInLibrary(){
        library.addBook(book);
        assertEquals(false, library.isBookInLibrary(book2));
    }

    @Test
    public void canRemoveBookFromLibraryWhenBookInLibrary(){
        library.addBook(book);
        library.removeBook(book);
        assertEquals(0, library.getNoOfBooks());
    }

    @Test
    public void canNotRemoveBookFromLibraryWhenBookIsNotInLibrary(){
        library.addBook(book);
        library.removeBook(book2);
        assertEquals(1, library.getNoOfBooks());
    }

    @Test
    public void checkStockIsNotFull(){
        assertEquals(false, library.isStockFull());
    }

    @Test
    public void checkStockIsFull(){
        Library smallLibrary = new Library("Small Library", 2);
        smallLibrary.addBook(book);
        smallLibrary.addBook(book);
        assertEquals(true, smallLibrary.isStockFull());
    }

    @Test
    public void cantAddBooksBeyondCapacity(){
        Library verySmallLibrary = new Library("Very Small Library", 1);
        verySmallLibrary.addBook(book);
        verySmallLibrary.addBook(book);
        assertEquals(1, verySmallLibrary.getNoOfBooks());
        assertEquals(true, verySmallLibrary.isStockFull());
    }
}
