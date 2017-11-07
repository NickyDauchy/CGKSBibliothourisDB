package be.cegeka.bibliothouris.domain.books;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class BookRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public List<Book> searchBookByISBN(String isbn) {
        isbn=isbn.replace('?','%');
        isbn=isbn.replace('*','%');
        
        return entityManager.createQuery("Select b from Book b where b.isbn like :isbn",Book.class)
                .setParameter("isbn", isbn )
                .getResultList();


    }

    public List<Book> searchBookByTitle(String title){
        title = title.replace('?', '%');
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

    public List<Book> searchBookByAuthor(String author) {
        author = author.replace('?','%');
        author = author.replace('*','%');

        return  entityManager.createQuery("Select b from Book b where concat(b.authorFirstName, b.authorLastName) like :author or concat(b.authorLastName, b.authorFirstName) like :author" ,Book.class)
                .setParameter("author","%"+author+"%")
                .getResultList();
    }

    public void borrowBook(BorrowedBook borrowedBook){
        entityManager.persist(borrowedBook);
    }

    public List<BorrowedBook> getAllBorrowedBooks(){
        return entityManager.createQuery("select c from BorrowedBook c",BorrowedBook.class).getResultList();
    }
}
