import java.util.ArrayList;

public class Borrower {

    private String name;
    private ArrayList<Book> collection;

    public Borrower(String name){
        this.name = name;
        this.collection = new ArrayList<Book>();
    }

    public String getName() {
        return this.name;
    }

    public int noOfBooks() {
        return this.collection.size();
    }

    public void addBook(Book book) {
        this.collection.add(book);
    }

    public boolean isBookInCollection(Book book){
        if(collection.contains(book)){
            return true;
        }
        return false;
    }

    public Book removeBook(Book book) {
        if(isBookInCollection(book)){
            int index = collection.indexOf(book);
            return collection.remove(index);
        }
        return null;
    }

    public void borrowFromLibrary(Library library, Book book) {
        Book removedBook = library.removeBook(book);
        if(removedBook != null){
            this.collection.add(removedBook);
        }
    }
}
