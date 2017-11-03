package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.users.Book;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

public class BookRepositoryTest {

    @Inject
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

}