package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import java.util.List;

public class BookService {
    @Inject
    BookRepository bookRepository;

    public List<Book> searchBookByISBN(String isbn) {
        return bookRepository.searchBookByISBN(isbn);
    }

    public void addBook(String isbn, String title, String authorLastName, String authorFirstName) {
        bookRepository.addBook(new Book(isbn,title,authorLastName,authorFirstName));
    }
}
