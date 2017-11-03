package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.users.Book;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class BookRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public List<Book> searchBookByISBN(String isbn) {
        return entityManager.createQuery("Select books from books where isbn like '%isbn%'",Book.class).getResultList();
    }
}
