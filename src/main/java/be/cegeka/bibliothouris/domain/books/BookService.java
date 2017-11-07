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

    public boolean validateISBN(String isbn) {
        if (isbn == null) {
            return false;
        }
        isbn = isbn.replaceAll("-", "");
        if (isbn.length() != 13) {
            return false;
        }
        try {
            int tot = 0;
            for (int i = 0; i < 12; i++) {
                int digit = Integer.parseInt(isbn.substring(i, i + 1));
                tot += (i % 2 == 0) ? digit * 1 : digit * 3;
            }

            //checksum must be 0-9. If calculated as 10 then = 0
            int checksum = 10 - (tot % 10);
            if (checksum == 10) {
                checksum = 0;
            }

            return checksum == Integer.parseInt(isbn.substring(12));
        } catch (NumberFormatException nfe) {
            //to catch invalid ISBNs that have non-numeric characters in them
            return false;
        }
    }
}
