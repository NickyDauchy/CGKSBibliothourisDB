package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class BorrowedBookTest {
    private BorrowedBook borrowedBook;

    @Before
    public void setUp() throws Exception {
        borrowedBook=new BorrowedBook(1,1, java.sql.Date.valueOf(LocalDate.now()),java.sql.Date.valueOf(LocalDate.now().plusWeeks(3)));
    }

    @Test
    public void getBookIdOfBorrowedBook() throws Exception {
        assertThat(borrowedBook.getBookid()).isEqualTo(1);
    }

    @Test
    public void getUserIdOfBorrowedBook() throws Exception {
        assertThat(borrowedBook.getUserid()).isEqualTo(1);
    }

    @Test
    public void getIdOfBorrowedBook() throws Exception {
        assertThat(borrowedBook.getId()).isEqualTo(borrowedBook.getId());
    }

    @Test
    public void getStartDateOfBorrowedBook() throws Exception {
        assertThat(borrowedBook.getStartdate()).isEqualTo(java.sql.Date.valueOf(LocalDate.now()));
    }

    @Test
    public void getDueDateOfBorrowedBook() throws Exception {
        assertThat(borrowedBook.getDuedate()).isEqualTo(java.sql.Date.valueOf(LocalDate.now().plusWeeks(3)));
    }

    @Test
    public void name() throws Exception {
    }
    @Test
    public void equals_SameBook_isTrue() throws Exception {
        assertThat(borrowedBook).isEqualTo(borrowedBook);
    }

    @Test
    public void equals_BookWithSameBookIDUserIDBorrowDateAndDueDate_isTrue() throws Exception {
        assertThat(borrowedBook).isEqualTo(new BorrowedBook(1,1, java.sql.Date.valueOf(LocalDate.now()),java.sql.Date.valueOf(LocalDate.now().plusWeeks(3))));
    }

    @Test
    public void equals_NullObject_isFalse() throws Exception {
        assertThat(borrowedBook).isNotEqualTo(null);
    }

    @Test
    public void equals_ifOtherClass_isFalse() throws Exception {
        assertThat(borrowedBook).isNotEqualTo(new Object());
    }

    @Test
    public void equals_BookWithOtherBookID_isFalse() throws Exception {
        assertThat(borrowedBook).isNotEqualTo(new BorrowedBook(2,1, java.sql.Date.valueOf(LocalDate.now()),java.sql.Date.valueOf(LocalDate.now().plusWeeks(3))));
    }

    @Test
    public void equals_BookWithOtherUserID_isFalse() throws Exception {
        assertThat(borrowedBook).isNotEqualTo(new BorrowedBook(1,2, java.sql.Date.valueOf(LocalDate.now()),java.sql.Date.valueOf(LocalDate.now().plusWeeks(3))));
    }

    @Test
    public void equals_BookWithOtherStartDate_isFalse() throws Exception {
        assertThat(borrowedBook).isNotEqualTo(new BorrowedBook(1,1, java.sql.Date.valueOf(LocalDate.now().plusDays(5)),java.sql.Date.valueOf(LocalDate.now().plusWeeks(3))));
    }

    @Test
    public void equals_BookWithOtherDueDate_isFalse() throws Exception {
        assertThat(borrowedBook).isNotEqualTo(new BorrowedBook(1,1, java.sql.Date.valueOf(LocalDate.now()),java.sql.Date.valueOf(LocalDate.now().plusWeeks(5))));
    }


    @Test
    public void equals_ObjectWithNullStartDate_IsFalse() throws Exception {
        assertThat(borrowedBook).isNotEqualTo(new BorrowedBook(1,1, null, java.sql.Date.valueOf(LocalDate.now().plusWeeks(3))));
    }

    @Test
    public void equals_ObjectWithNullDueDate_IsFalse() throws Exception {
        assertThat(borrowedBook).isNotEqualTo(new BorrowedBook(1,1, java.sql.Date.valueOf(LocalDate.now()),null));
    }


    @Test
    public void equals_ObjectWithBothNullStartDate_IsTrue() throws Exception {
        assertThat(new BorrowedBook(1,1, null, java.sql.Date.valueOf(LocalDate.now().plusWeeks(3)))).
                isEqualTo(new BorrowedBook(1,1, null, java.sql.Date.valueOf(LocalDate.now().plusWeeks(3))));
    }

    @Test
    public void equals_ObjectWithBothNullDueDate_IsTrue() throws Exception {
        assertThat(new BorrowedBook(1,1, java.sql.Date.valueOf(LocalDate.now()),null)).
                isEqualTo(new BorrowedBook(1,1, java.sql.Date.valueOf(LocalDate.now()),null));
    }


    @Test
    public void equals_ObjectWithNoNullStartDate_IsFalse() throws Exception {
        assertThat(new BorrowedBook(1,1, null,java.sql.Date.valueOf(LocalDate.now().plusWeeks(3)))).
                isNotEqualTo(new BorrowedBook(1,1, java.sql.Date.valueOf(LocalDate.now()),java.sql.Date.valueOf(LocalDate.now().plusWeeks(3))));
    }

    @Test
    public void equals_ObjectWithNoNullDueDate_IsFalse() throws Exception {
        assertThat(new BorrowedBook(1,1, java.sql.Date.valueOf(LocalDate.now()),null)).
                isNotEqualTo(new BorrowedBook(1,1, java.sql.Date.valueOf(LocalDate.now()),java.sql.Date.valueOf(LocalDate.now().plusWeeks(3))));
    }
}
