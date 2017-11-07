package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.BookService;
import be.cegeka.bibliothouris.domain.books.Book;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping(path = "/book")
@Transactional
public class BookController {
    @Inject
    private BookService bookService;

    @GetMapping(path = "/searchBookByISBN")
    @Secured("ROLE_USER")
    public List<Book> searchBookByISBN(@RequestParam(value = "ISBN", required = true) String ISBN) {
        return bookService.searchBookByISBN(ISBN);
    }

    @PostMapping(path = "/addBook")
    @Secured("ROLE_LIBRARIAN")
    public void addBook(@RequestParam(value = "isbn", required = true) String ISBN,
                        @RequestParam(value = "title", required = true) String title,
                        @RequestParam(value = "authorLastName", required = true) String authorLastName,
                        @RequestParam(value = "authorFirstName", required = false) String authorFirstName) {
        if (authorFirstName != null) {
            bookService.addBook(ISBN, title, authorLastName, authorFirstName);
        } else {
            bookService.addBook(ISBN, title, authorLastName);
        }
    }

    @GetMapping(path = "/getAllBooks")
    @Secured("ROLE_USER")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/getBookDetails")
    @Secured("ROLE_USER")
    public Book getBookDetails(@RequestParam(value = "id", required = true) int id) {
        return bookService.getBookDetails(id);
    }

    @GetMapping(path = "/searchBookByTitle")
    @Secured("ROLE_USER")
    public List<Book> searchBookByTitle(@RequestParam(value = "title", required = true) String title) {
        return bookService.searchBookByTitle(title);
    }

    @GetMapping(path = "/searchBookByAuthor")
    @Secured("ROLE_USER")
    public List<Book> searchBookByAuthor(@RequestParam(value = "author", required = true) String author) {
        return bookService.searchBookByAuthor(author);
    }

    @PostMapping(path="/borrowBook")
    @Secured("ROLE_USER")
    public void borrowBook(@RequestParam(value="bookid",required = true)int bookid,@RequestParam(value="userid",required = true)int userid){
        bookService.borrowBook(bookid,userid);
    }
}
