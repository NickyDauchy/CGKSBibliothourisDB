package be.cegeka.bibliothouris.domain.books;

import org.springframework.test.util.ReflectionTestUtils;

public class BookTestBuilder {

    private String isbn;
    private String title;
    private String authorLastName;
    private String authorFirstName;
    private int id;

    public static BookTestBuilder aBook(){
        return new BookTestBuilder()
                .withIsbn("123456")
                .withTitle("Kikis Day Out")
                .withAuthorLastName("Willems")
                .withAuthorFirstName("Kiki");
    }

    public Book build() {
        Book book = new Book(isbn, title, authorLastName, authorFirstName);
        ReflectionTestUtils.setField(book, "id", id);
        return book;
    }

    public BookTestBuilder withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookTestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookTestBuilder withAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public BookTestBuilder withAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public BookTestBuilder withId(int id) {
        this.id = id;
        return this;
    }

}
