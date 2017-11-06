package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookRepository;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BookControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;


    @Test
    public void searchBookByISBN_ShouldCallBookrepository() throws Exception {
        Book book1 = new Book("123456", "Kikis Day Out", "Willems", "Kiki");
        Book book2 = new Book("123457", "Kikis Day Out Volume 2", "Willems", "Kiki");

        when(bookService.searchBookByISBN("34")).thenReturn(Arrays.asList(book1, book2));

        Assertions.assertThat(bookController.searchBookByISBN("34")).containsOnly(book1, book2);
    }
}