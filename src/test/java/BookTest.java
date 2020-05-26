import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void before(){
        book = new Book("The Northern Lights", "Philip Pullman", "Science Fantasy");
    }

    @Test
    public void hasTitle(){
        assertEquals("The Northern Lights", book.getTitle());
    }

    @Test
    public void hasAuthor(){
        assertEquals("Philip Pullman", book.getAuthor());
    }

    @Test
    public void hasGenre(){
        assertEquals("Science Fantasy", book.getGenre());
    }
}
