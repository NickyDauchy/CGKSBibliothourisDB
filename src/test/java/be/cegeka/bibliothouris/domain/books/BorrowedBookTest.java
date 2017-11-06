package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class BorrowedBookTest {
    private BorrowedBook borrowedBook;

    @Before
    public void setUp() throws Exception {
        borrowedBook=new BorrowedBook(1,1, java.sql.Date.valueOf(LocalDate.now()),java.sql.Date.valueOf(LocalDate.now().plusWeeks(3)));
    }

    @Test
    public void getBookIdOfBorrowedBook() throws Exception {
        Assertions.assertThat(borrowedBook.getBookid()).isEqualTo(1);
    }

    @Test
    public void getUserIdOfBorrowedBook() throws Exception {
        Assertions.assertThat(borrowedBook.getUserid()).isEqualTo(1);
    }

    @Test
    public void getIdOfBorrowedBook() throws Exception {
        Assertions.assertThat(borrowedBook.getId()).isEqualTo(borrowedBook.getId());
    }

    @Test
    public void getStartDateOfBorrowedBook() throws Exception {
        Assertions.assertThat(borrowedBook.getStartdate()).isEqualTo("2017-11-06");
    }

    @Test
    public void getDueDateOfBorrowedBook() throws Exception {
        Assertions.assertThat(borrowedBook.getDuedate()).isEqualTo("2017-11-27");
    }
}