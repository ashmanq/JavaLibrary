import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book;

    @Before
    public void before(){
        book = new Book("1984", "George Orwell", "Dystopian Fiction");
        library = new Library("Motherwell Library");
    }

    @Test
    public void libraryHasName(){
        assertEquals("Motherwell Library", library.getName());
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
}
