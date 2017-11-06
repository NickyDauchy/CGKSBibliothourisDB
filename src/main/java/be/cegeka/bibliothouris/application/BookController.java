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

    @RequestMapping(path = "/searchBookByISBN")
    @GetMapping
    public List<Book> searchBookByISBN(@RequestParam(value = "ISBN", required = true) String ISBN) {
        return bookService.searchBookByISBN(ISBN);
    }


    @RequestMapping(path = "/addBook")
    @PostMapping
    @Secured("ROLE_LIBRARIAN")
    public void addBook(@RequestParam(value = "isbn", required = true) String ISBN,
                        @RequestParam(value = "title", required = true) String title,
                        @RequestParam(value = "authorLastName", required = true) String authorLastName,
                        @RequestParam(value = "authorFirstName", required = true) String authorFirstName) {
        bookService.addBook(ISBN, title, authorLastName, authorFirstName);
    }

    @RequestMapping(path = "/getAllBooks")
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(path = "/getBookDetails")
    @GetMapping
    public Book getBookDetails(@RequestParam(value = "id", required = true) int id) {
        return bookService.getBookDetails(id);
    }

    @RequestMapping(path = "/searchBookByTitle")
    @GetMapping
    public List<Book> searchBookByTitle(@RequestParam(value = "title", required = true) String title) {
        return bookService.searchBookByTitle(title);
    }

    @RequestMapping(path = "/searchBookByAuthor")
    @GetMapping
    public List<Book> searchBookByAuthor(@RequestParam(value = "author", required = true) String author) {
        return bookService.searchBookByAuthor(author);
    }
    @RequestMapping(path="/borrowBook")
    @PostMapping
    public void borrowBook(@RequestParam(value="bookid",required = true)int bookid,@RequestParam(value="userid",required = true)int userid){
        bookService.borrowBook(bookid,userid);
    }
}
