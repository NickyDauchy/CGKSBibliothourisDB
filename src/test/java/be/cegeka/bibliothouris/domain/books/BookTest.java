package be.cegeka.bibliothouris.domain.books;

import org.junit.Before;
import org.junit.Test;
//import static be.cegeka.bibliothouris.domain.books.BookTestBuilder.aBook;
import static be.cegeka.bibliothouris.domain.books.BookTestBuilder.aBook;
import static org.junit.Assert.*;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    private Book book;

    @Before
    public void setup() {
        book = aBook()
                .withIsbn("123456")
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki")
                .withId(7)
                .build();
    }

    @Test
    public void equals_SameObject_IsTrue() throws Exception {
        assertThat(book).isEqualTo(book);
    }

    @Test
    public void equals_ObjectWithSameIdAndName_IsTrue() throws Exception {
        assertThat(book).isEqualTo(aBook()
                .withIsbn("123456")
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki")
                .withId(7)
                .build()
        );
    }

    @Test
    public void equals_NullObject_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(null);
    }

    @Test
    public void equals_OtherClass_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Object());
    }

    @Test
    public void equals_ObjectWithOtherId_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(aBook()
                .withId(9)
                .withIsbn("123456")
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki")
                .build());
    }

    @Test
    public void equals_ObjectWithOtherIsbn_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(aBook()
                .withId(7)
                .withIsbn("123455")
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki")
                .build());
    }

    @Test
    public void equals_ObjectWithOtherAuthorFirstName_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(aBook()
                .withId(7)
                .withIsbn("123455")
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kika")
                .build());
    }

    @Test
    public void equals_ObjectWithOtherTitle_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(aBook()
                .withId(7)
                .withIsbn("123455")
                .withTitle("Kikis Yummy Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki")
                .build());
    }

    @Test
    public void equals_ObjectWithOtherAuthorLastName_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(aBook()
                .withId(7)
                .withIsbn("123455")
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Williams")
                .withAuthorFirstName("Kiki")
                .build());
    }

    @Test
    public void equals_ObjectWithNullIsbn_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(aBook()
                .withId(7)
                .withIsbn(null)
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki")
                .build());
    }

    @Test
    public void equals_ObjectWithBothNullIsbn_IsTrue() throws Exception {
        assertThat(aBook()
                .withId(7)
                .withIsbn(null)
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki")
                .build())
                .isEqualTo(aBook()
                        .withId(7)
                        .withIsbn(null)
                        .withTitle("Kikis Day Out")
                        .withAuthorLastName("Willems")
                        .withAuthorFirstName("Kiki")
                        .build());
    }

    @Test
    public void equals_ObjectWithNoNullIsbn_IsFalse() throws Exception {
        assertThat(aBook()
                .withId(7)
                .withIsbn(null)
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki")
                .build()).
                isNotEqualTo(aBook()
                        .withId(7)
                        .withIsbn("123455")
                        .withTitle("Kikis Day Out")
                        .withAuthorLastName("Willems")
                        .withAuthorFirstName("Kiki")
                        .build());
    }


    @Test
    public void equals_ObjectWithNullTitle_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(aBook()
                .withId(7)
                .withIsbn("123456")
                .withTitle(null)
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki")
                .build());
    }

    @Test
    public void equals_ObjectWithBothNullTitle_IsTrue() throws Exception {
        assertThat(aBook()
                .withId(7)
                .withIsbn("123456")
                .withTitle(null)
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki")
                .build())
                .isEqualTo(aBook()
                        .withId(7)
                        .withIsbn("123456")
                        .withTitle(null)
                        .withAuthorLastName("Willems")
                        .withAuthorFirstName("Kiki")
                        .build());
    }

    @Test
    public void equals_ObjectWithNoNullTitle_IsFalse() throws Exception {
        assertThat(aBook()
                .withId(7)
                .withIsbn("123456")
                .withTitle(null)
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki")
                .build()).
                isNotEqualTo(aBook()
                        .withId(7)
                        .withIsbn("123455")
                        .withTitle("Kikis Day Out")
                        .withAuthorLastName("Willems")
                        .withAuthorFirstName("Kiki")
                        .build());
    }


    @Test
    public void equals_ObjectWithNullAuthorLastName_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(aBook()
                .withId(7)
                .withIsbn("123456")
                .withTitle("Kikis Day Out")
                .withAuthorLastName(null)
                .withAuthorFirstName("Kiki")
                .build());
    }

    @Test
    public void equals_ObjectWithBothNullAuthorLastName_IsTrue() throws Exception {
        assertThat(aBook()
                .withId(7)
                .withIsbn("123456")
                .withTitle("Kikis Day Out")
                .withAuthorLastName(null)
                .withAuthorFirstName("Kiki")
                .build())
                .isEqualTo(aBook()
                        .withId(7)
                        .withIsbn("123456")
                        .withTitle("Kikis Day Out")
                        .withAuthorLastName(null)
                        .withAuthorFirstName("Kiki")
                        .build());
    }

    @Test
    public void equals_ObjectWithNoNullAuthorLastName_IsFalse() throws Exception {
        assertThat(aBook()
                .withId(7)
                .withIsbn("123456")
                .withTitle("Kikis Day Out")
                .withAuthorLastName(null)
                .withAuthorFirstName("Kiki")
                .build()).
                isNotEqualTo(aBook()
                        .withId(7)
                        .withIsbn("123455")
                        .withTitle("Kikis Day Out")
                        .withAuthorLastName("Willems")
                        .withAuthorFirstName("Kiki")
                        .build());
    }

    @Test
    public void equals_ObjectWithNullAuthorFirstName_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(aBook()
                .withId(7)
                .withIsbn("123456")
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName(null)
                .build());
    }

    @Test
    public void equals_ObjectWithBothNullAuthorFirstName_IsTrue() throws Exception {
        assertThat(aBook()
                .withId(7)
                .withIsbn("123456")
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName(null)
                .build())
                .isEqualTo(aBook()
                        .withId(7)
                        .withIsbn("123456")
                        .withTitle("Kikis Day Out")
                        .withAuthorLastName("Willems")
                        .withAuthorFirstName(null)
                        .build());
    }

    @Test
    public void equals_ObjectWithNoNullAuthorFirstName_IsFalse() throws Exception {
        assertThat(aBook()
                .withId(7)
                .withIsbn("123456")
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName(null)
                .build()).
                isNotEqualTo(aBook()
                        .withId(7)
                        .withIsbn("123455")
                        .withTitle("Kikis Day Out")
                        .withAuthorLastName("Willems")
                        .withAuthorFirstName("Kiki")
                        .build());
    }

}