package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.Application;
import be.cegeka.bibliothouris.domain.books.Book;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static javafx.scene.input.KeyCode.L;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@Transactional
public class BookRepositoryTest {

    @Inject
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;
    private Book testboek1;
    private Book testboek2;
    private Book testboek3;
    private BorrowedBook testborrowedboek1;
    private BorrowedBook testborrowedboek2;
    private BorrowedBook testborrowedboek3;

    @Before
    public void setUp() throws Exception {
        testboek1=new Book("a123a","testbook1","romeo","mattia");
        testboek2=new Book("789","testbook2","romeo","mattia");
        testboek3=new Book("afvo123", "testbook3", "willems", "kiki");
        testborrowedboek1=new BorrowedBook(0,0, Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusWeeks(3)),null);
        testborrowedboek1=new BorrowedBook(1,0, Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusWeeks(3)),null);
        testborrowedboek1=new BorrowedBook(2,0, Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusWeeks(3)),null);


        entityManager.persist(testboek1);
        entityManager.persist(testboek2);
        entityManager.persist(testboek3);
        entityManager.persist(testborrowedboek1);
        entityManager.persist(testborrowedboek2);
        entityManager.persist(testborrowedboek3);
    }

    @Test
    public void addBookToRepository() throws Exception {
        assertThat(bookRepository.getAllBooks()).contains(testboek1, testboek2);
    }

    @Test
    public void testSearchBookByISBN123ReturnsBookCreatedWithISBN123() throws Exception {
        List<Book> actual = bookRepository.searchBookByISBN("?123?");

        assertThat(actual).contains(testboek3, testboek1);
    }

    @Test
    public void testSearchBookByISBN123ReturnsBookCreatedWithISBNa() throws Exception {
        List<Book> actual = bookRepository.searchBookByISBN("*a*");

        assertThat(actual).contains(testboek3, testboek1);
    }

    @Test
    public void searchBookByISBN123_asterisk_aShouldReturnCorrectBook() throws Exception {
        List<Book> actual = bookRepository.searchBookByISBN("a*");

        Assertions.assertThat(actual).contains(testboek1);
    }
    @Test
    public void searchBookByISBN1_3_ShouldReturnCorrectBook() throws Exception {
        List<Book> actual = bookRepository.searchBookByISBN("*1?3*");

        Assertions.assertThat(actual).contains(testboek1,testboek3);
    }

    @Test
    public void getAllBooksContains2BooksFromBefore() throws Exception {
        assertThat(bookRepository.getAllBooks()).contains(testboek2, testboek1);
    }

    @Test
    public void getBookDetailsById_ShouldReturnAllDetailsOfBookWithSaidId() throws Exception {
        assertThat(bookRepository.getBookDetails(testboek1.getId())).isEqualTo(testboek1);
    }

    @Test
    public void whenGivenPartOfTitle_shouldReturnListOfBooksWithMatchingTitlePart() throws Exception {
        List<Book> actual = bookRepository.searchBookByTitle("Test");

        assertThat(actual).contains(testboek2);
    }

    @Test
    public void whenGivenPartOfTitleOfMultipleBooks_shouldReturnAllBooks() throws Exception {
        List<Book> actual = bookRepository.searchBookByTitle("Erwin");
        assertThat(actual).isEmpty();
    }
    @Test
    public void searchBookByISBN____ShouldReturnCorrectBook() throws Exception {
        List<Book> actual = bookRepository.searchBookByISBN("???");

        Assertions.assertThat(actual).contains(testboek1,testboek3);
    }

    @Test
    public void searchBookByAuthorPartLastAndFirstName_ShouldReturnCorrectBooks() throws Exception {
        List<Book> actual = bookRepository.searchBookByAuthor("oma");

        Assertions.assertThat(actual).contains(testboek2, testboek1);
    }

    @Test
    public void searchBookByAuthorPartFirstAndLastName_ShouldReturnCorrectBooks() throws Exception {
        List<Book> actual = bookRepository.searchBookByAuthor("iar");

        Assertions.assertThat(actual).contains(testboek2, testboek1);
    }

    @Test
    public void searchBookByUnexistingAuthor_ShouldReturnEmptyList() throws Exception {
        List<Book> actual = bookRepository.searchBookByAuthor("ele");

        Assertions.assertThat(actual).isEmpty();
    }


    @Test
    public void addBorrowedBookToBorrowedBookTable() throws Exception {
        Assertions.assertThat(bookRepository.getAllBorrowedBooks()).contains(testborrowedboek1);
    }
}