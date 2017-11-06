package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.books.Book;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class BookRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public List<Book> searchBookByISBN(String isbn) {

//        String searchExpression=isbn;
//        String searchExpression;
//        String searchExpression=searchExpression.replace('*','%');
//        find '?' wildcard for single character
//        find '*' wildcard for multiple characters

//        "SELECT c FROM Customer c WHERE c.name LIKE :custName")
//        .setParameter("custName", name)
//                .getResultList();

        return entityManager.createQuery("Select b from Book b where b.isbn like :isbn",Book.class)
                .setParameter("isbn", "%"+isbn+"%" )
                .getResultList();


    }

    public List<Book> searchBookByTitle(String title){
        title = title.replace('*','%');

        return  entityManager.createQuery("Select b from Book b where b.title like :title",Book.class)
                .setParameter("title","%"+title+"%")
                .getResultList();
    }

    public void addBook(Book book) {
        entityManager.persist(book);
    }

    public List<Book> getAllBooks() {
        return entityManager.createQuery("Select b from Book b",Book.class).getResultList();
    }

    public Book getBookDetails(int id){
        return entityManager.find(Book.class, id);
    }
}
