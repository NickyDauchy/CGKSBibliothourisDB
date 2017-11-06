package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    public void whenAddBook_shouldReturnBookService() throws Exception {
        bookController.addBook("12345", "Erwins angels", "Boegiewoegie", "Erwin");

        verify(bookService).addBook("12345", "Erwins angels", "Boegiewoegie", "Erwin");
    }

    @Test
    public void getAllBooks() throws Exception {
        Book book1 = new Book("12345", "Erwins angels", "Boegiewoegie", "Erwin");
        Book book2 = new Book("12346", "Erwins devils", "Boegiewoegie", "Erwin");
        Book book3 = new Book("12347", "Erwins demons", "Boegiewoegie", "Erwin");

        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1,book2,book3));
        assertThat(bookController.getAllBooks()).containsOnly(book1,book2,book3);
    }
}