package be.cegeka.bibliothouris.domain.books;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="BORROWEDBOOKS")
public class BorrowedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="BOOKID")
    private int bookid;
    @Column(name="USERID")
    private int userid;
    @Column(name="STARTDATE")
    private Date startdate;
    @Column(name="DUEDATE")
    private Date duedate;
    @Column(name="RETURNDATE")
    private Date returndate;

    public BorrowedBook(){

    }

    public BorrowedBook(int bookid, int userid, Date startdate, Date duedate) {
        this.bookid = bookid;
        this.userid = userid;
        this.startdate = startdate;
        this.duedate = duedate;
    }

    public int getId() {
        return id;
    }

    public int getBookid() {
        return bookid;
    }

    public int getUserid() {
        return userid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public Date getDuedate() {
        return duedate;
    }

    public Date getReturndate() {
        return returndate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BorrowedBook that = (BorrowedBook) o;

        if (id != that.id) return false;
        if (bookid != that.bookid) return false;
        if (userid != that.userid) return false;
        if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) return false;
        if (duedate != null ? !duedate.equals(that.duedate) : that.duedate != null) return false;
        return returndate != null ? returndate.equals(that.returndate) : that.returndate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bookid;
        result = 31 * result + userid;
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (duedate != null ? duedate.hashCode() : 0);
        result = 31 * result + (returndate != null ? returndate.hashCode() : 0);
        return result;
    }
}
