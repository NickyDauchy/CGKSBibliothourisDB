package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


import javax.inject.Inject;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class BookServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;


    @Test
    public void searchBookByISBN_ShouldCallBookrepository() throws Exception {
        Book book1 = new Book("123456", "Kikis Day Out", "Willems", "Kiki");
        Book book2 = new Book("123457", "Kikis Day Out Volume 2", "Willems", "Kiki");

        when(bookRepository.searchBookByISBN("34")).thenReturn(Arrays.asList(book1, book2));

        Assertions.assertThat(bookService.searchBookByISBN("34")).containsOnly(book1, book2);
    }

    @Test
    public void addBook_shouldReturnBookRepository() throws Exception {
        bookService.addBook("12345", "Erwins angels", "Boegiewoegie", "Erwin");

        verify(bookRepository).addBook(new Book("12345", "Erwins angels", "Boegiewoegie", "Erwin"));
    }

    @Test
    public void getAllBooks() throws Exception {
        Book book1 = new Book("12345", "Erwins angels", "Boegiewoegie", "Erwin");
        Book book2 = new Book("12346", "Erwins devils", "Boegiewoegie", "Erwin");
        Book book3 = new Book("12347", "Erwins demons", "Boegiewoegie", "Erwin");

        when(bookRepository.getAllBooks()).thenReturn(Arrays.asList(book1, book2, book3));

        assertThat(bookService.getAllBooks()).containsOnly(book1, book2, book3);
    }

    @Test
    public void getBookDetailsById_ShouldReturnAllDetailsOfBookWithSaidId() throws Exception {
        Book testboek1 = new Book("123", "testbook1", "romeo", "mattia");
        when(bookRepository.getBookDetails(testboek1.getId())).thenReturn(testboek1);

        assertThat(bookService.getBookDetails(testboek1.getId())).isEqualTo(testboek1);
    }
}