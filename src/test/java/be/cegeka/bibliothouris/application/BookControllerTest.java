package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;

import be.cegeka.bibliothouris.domain.books.BookRepository;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.assertj.core.api.Assertions;

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
        when(bookService.validateISBN("978-0-13-235088-4")).thenReturn(true);
        bookController.addBook("978-0-13-235088-4", "Erwins angels", "Boegiewoegie", "Erwin");
        verify(bookService).addBook("978-0-13-235088-4", "Erwins angels", "Boegiewoegie", "Erwin");
    }

    @Test
    public void whenAddBookWithoutAuthorFirstName_shouldReturnBookService() throws Exception {

        when(bookService.validateISBN("9789401443944")).thenReturn(true);
        bookController.addBook("9789401443944", "Erwins angels", "Boegiewoegie",null);

        verify(bookService).addBook("9789401443944", "Erwins angels", "Boegiewoegie");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidISBNReturnsFalse_shouldThrowIllegalArgumentExeption() throws Exception {
        when(bookService.validateISBN("9789401443944")).thenReturn(false);
        bookController.addBook("9789401443944", "Erwins angels", "Boegiewoegie",null);
    }

    @Test
    public void getAllBooks() throws Exception {
        Book book1 = new Book("9789401443944", "Erwins angels", "Boegiewoegie", "Erwin");
        Book book2 = new Book("9789401443944", "Erwins devils", "Boegiewoegie", "Erwin");
        Book book3 = new Book("9789401443944", "Erwins demons", "Boegiewoegie", "Erwin");

        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2, book3));
        assertThat(bookController.getAllBooks()).containsOnly(book1, book2, book3);
    }

    @Test
    public void searchBookByISBN_ShouldCallBookService() throws Exception {
        Book book1 = new Book("123456", "Kikis Day Out", "Willems", "Kiki");
        Book book2 = new Book("123457", "Kikis Day Out Volume 2", "Willems", "Kiki");

        when(bookService.searchBookByISBN("34")).thenReturn(Arrays.asList(book1, book2));

        Assertions.assertThat(bookController.searchBookByISBN("34")).containsOnly(book1, book2);
    }
    @Test
    public void getBookDetailsById_ShouldReturnAllDetailsOfBookWithSaidId() throws Exception {
        Book testboek1 = new Book("123", "testbook1", "romeo", "mattia");
        when(bookService.getBookDetails(testboek1.getId())).thenReturn(testboek1);

        assertThat(bookController.getBookDetails(testboek1.getId())).isEqualTo(testboek1);
    }

    @Test
    public void searchBookByTitle_ShouldCallBookService() throws Exception {
        Book book1 = new Book("123456", "Kikis Day Out", "Willems", "Kiki");
        Book book2 = new Book("123457", "Kikis Day Out Volume 2", "Willems", "Kiki");

        when(bookService.searchBookByTitle("Day")).thenReturn(Arrays.asList(book1, book2));

        Assertions.assertThat(bookController.searchBookByTitle("Day")).containsOnly(book1, book2);
    }

    @Test
    public void searchBookByAuthor_ShouldCallBookService() throws Exception {
        Book book1 = new Book("123456", "Kikis Day Out", "Willems", "Kiki");
        Book book2 = new Book("123457", "Kikis Day Out Volume 2", "Willems", "Kiki");

        when(bookService.searchBookByAuthor("ski")).thenReturn(Arrays.asList(book1, book2));

        Assertions.assertThat(bookController.searchBookByAuthor("ski")).containsOnly(book1, book2);
    }

    @Test
    public void borrowBookShouldCallBookService() throws Exception {
        bookController.borrowBook("1", 1);
        verify(bookService).borrowBook("1", 1);
    }
}