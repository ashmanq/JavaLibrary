import java.util.ArrayList;

public class Library {

    private String name;
    private ArrayList<Book> books;
    private int capacity;

    public Library(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.books = new ArrayList<Book>();
    }


    public String getName() {
        return this.name;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getNoOfBooks() {
        return this.books.size();
    }

    public void addBook(Book book) {
        if(!this.isStockFull()){
            this.books.add(book);
        }
    }

    public boolean isStockFull() {
        if(getNoOfBooks()<this.capacity){
            return false;
        }
        return true;
    }

    public Book removeBook(Book book) {
        if(isBookInLibrary(book)){
            int index = books.indexOf(book);
            return books.remove(index);
        }
        return null;
    }

    public boolean isBookInLibrary(Book book) {
        if(this.books.contains(book)){
            return true;
        }
        return false;
    }
}
