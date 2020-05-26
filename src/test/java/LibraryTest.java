import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book1, book2, book3, book4, book5;

    @Before
    public void before(){
        book1 = new Book("1984", "George Orwell", "Dystopian Fiction");
        book2 = new Book("The Subtle Art Of Not Giving A F*ck", "Mark Manson", "Self Help");
        book3 = new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "History");
        book4 = new Book("To Kill A Mockingbird", "Harper Lee", "Fiction");
        book5 = new Book("Brave New World", "Aldous Huxley", "Fiction");
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
        library.addBook(book1);
        assertEquals(1, library.getNoOfBooks());
    }

    @Test
    public void bookIsInLibrary(){
        library.addBook(book1);
        assertEquals(true, library.isBookInLibrary(book1));
    }

    @Test
    public void bookIsNotInLibrary(){
        library.addBook(book1);
        assertEquals(false, library.isBookInLibrary(book2));
    }

    @Test
    public void canRemoveBookFromLibraryWhenBookInLibrary(){
        library.addBook(book1);
        library.removeBook(book1);
        assertEquals(0, library.getNoOfBooks());
    }

    @Test
    public void canNotRemoveBookFromLibraryWhenBookIsNotInLibrary(){
        library.addBook(book1);
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
        smallLibrary.addBook(book1);
        smallLibrary.addBook(book3);
        assertEquals(true, smallLibrary.isStockFull());
    }

    @Test
    public void cantAddBooksBeyondCapacity(){
        Library verySmallLibrary = new Library("Very Small Library", 1);
        verySmallLibrary.addBook(book1);
        verySmallLibrary.addBook(book2);
        assertEquals(1, verySmallLibrary.getNoOfBooks());
        assertEquals(true, verySmallLibrary.isStockFull());
    }

    @Test
    public void getListOfGenres(){
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        ArrayList<String> expectedList = new ArrayList<String>(Arrays.asList("Dystopian Fiction", "Self Help", "History", "Fiction"));
        assertEquals(expectedList, library.getListOfUniqueGenres());
    }

    @Test
    public void getNoOfBooksForEachGenre(){
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        HashMap<String, Integer> expectedResult = new HashMap<String, Integer>() {{
            put("Dystopian Fiction", 1);
            put("Self Help", 1);
            put("History", 1);
            put("Fiction", 2);
        }};
        assertEquals(expectedResult, library.getBookNosByGenre());
    }
}
