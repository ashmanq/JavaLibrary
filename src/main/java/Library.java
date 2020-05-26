import com.sun.codemodel.internal.JForEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

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

    // Method to get unique lsit of genres from books in Library class
    public ArrayList<String> getListOfUniqueGenres() {
        ArrayList<String> genres = new ArrayList<String>();
        for(Book book : this.books) {
            if(!genres.contains(book.getGenre())) {
                genres.add(book.getGenre());
            }
        }
        return genres;
    }

    // Method that takes unique genre list and counts no of books
    // for each genre
    public HashMap<String, Integer> getBookNosByGenre() {
        ArrayList<String> genres = this.getListOfUniqueGenres();
        HashMap<String, Integer> bookNoByGenre = new HashMap<>();

        genres.forEach(genre -> {
            bookNoByGenre.put(genre, 0);

            this.books.forEach(book -> {
                if(book.getGenre() == genre){
                    int count = bookNoByGenre.get(genre);
                    bookNoByGenre.put(genre, count+1);
                }
            });
        });

        return bookNoByGenre;
    }
}
