import java.util.ArrayList;

public class Library {

    private String name;
    private ArrayList<Book> books;

    public Library(String name){
        this.name = name;
        this.books = new ArrayList<Book>();
    }


    public String getName() {
        return this.name;
    }

    public int getNoOfBooks() {
        return this.books.size();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }
}
