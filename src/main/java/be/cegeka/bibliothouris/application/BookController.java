package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.BookService;
import be.cegeka.bibliothouris.domain.books.Book;
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


    @RequestMapping(path="/addBook")
    @PostMapping
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
}
