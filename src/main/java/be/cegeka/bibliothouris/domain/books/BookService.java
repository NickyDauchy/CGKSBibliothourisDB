package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.users.Book;

import javax.inject.Inject;
import java.util.List;

public class BookService {
    @Inject
    BookRepository bookRepository;

    public List<Book> searchBookByISBN(String isbn) {
        return bookRepository.searchBookByISBN(isbn);
    }
}
