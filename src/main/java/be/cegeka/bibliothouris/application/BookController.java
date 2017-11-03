package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.BookService;
import be.cegeka.bibliothouris.domain.users.Book;
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

    @RequestMapping(path="/searchBookByISBN")
    @GetMapping
    public List<Book> searchBookByISBN(@RequestParam(value="ISBN",required = true)String ISBN){return bookService.searchBookByISBN(ISBN);}



}
