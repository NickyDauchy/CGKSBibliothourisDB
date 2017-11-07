package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public void borrowBook(String isbn, int userid) {
        List<Book> boekenMetDezeISBNLijst = bookRepository.searchBookByISBN(isbn);
        for (Book book : boekenMetDezeISBNLijst) {
            if (book.getBorrowable()) {
                bookRepository.borrowBook(new BorrowedBook(book.getId(), userid, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusWeeks(3))));
                book.borrowThisBook();
                break;
            }
        }
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
