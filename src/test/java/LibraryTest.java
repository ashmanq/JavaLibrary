import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book;

    @Before
    public void before(){
        book = new Book("1984", "George Orwell", "Dystopian Fiction");
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
