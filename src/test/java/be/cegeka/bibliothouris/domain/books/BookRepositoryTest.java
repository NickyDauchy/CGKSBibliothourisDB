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

import java.util.List;

import static javafx.scene.input.KeyCode.L;
import static org.junit.Assert.*;

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

    @Before
    public void setUp() throws Exception {
        testboek1=new Book("a123a","testbook1","romeo","mattia");
        testboek2=new Book("789","testbook2","romeo","mattia");
        testboek3=new Book("afvo123", "testbook3", "willems", "kiki");

        entityManager.persist(testboek1);
        entityManager.persist(testboek2);
        entityManager.persist(testboek3);
    }

    @Test
    public void addBookToRepository() throws Exception {
        Assertions.assertThat(bookRepository.getAllBooks()).contains(testboek1,testboek2);
    }

    @Test
    public void testSearchBookByISBN123ReturnsBookCreatedWithISBN123() throws Exception {
        List<Book> actual = bookRepository.searchBookByISBN("123");

        Assertions.assertThat(actual).contains(testboek3, testboek1);
    }
    @Test
    public void testSearchBookByISBN123ReturnsBookCreatedWithISBNa() throws Exception {
        List<Book> actual = bookRepository.searchBookByISBN("a");

        Assertions.assertThat(actual).contains(testboek3, testboek1);
    }



    @Test
    public void getAllBooksContains2BooksFromBefore() throws Exception {
        Assertions.assertThat(bookRepository.getAllBooks()).contains(testboek2,testboek1);
    }

    @Test
    public void getBookDetailsById_ShouldReturnAllDetailsOfBookWithSaidId() throws Exception {
        Assertions.assertThat(bookRepository.getBookDetails(testboek1.getId())).isEqualTo(testboek1);
    }
}