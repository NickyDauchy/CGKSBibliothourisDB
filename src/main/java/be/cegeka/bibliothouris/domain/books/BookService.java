package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BookService {
    @Inject
    private BookRepository bookRepository;

    public List<Book> searchBookByISBN(String isbn) {
        return bookRepository.searchBookByISBN(isbn);
    }

    public void addBook(String isbn, String title, String authorLastName, String authorFirstName) {
        bookRepository.addBook(new Book(isbn, title, authorLastName, authorFirstName));
    }

    public void addBook(String isbn, String title, String authorLastName) {
        bookRepository.addBook(new Book(isbn, title, authorLastName, ""));
    }


    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getBookDetails(int id) {
        return bookRepository.getBookDetails(id);
    }

    public List<Book> searchBookByTitle(String title) {
        return bookRepository.searchBookByTitle(title);
    }

    public List<Book> searchBookByAuthor(String author) {
        return bookRepository.searchBookByAuthor(author);
    }
}
