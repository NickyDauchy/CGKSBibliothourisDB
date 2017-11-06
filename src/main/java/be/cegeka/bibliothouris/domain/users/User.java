package be.cegeka.bibliothouris.domain.users;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "INSS")
    private String inss;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSENUMBER")
    private String houseNumber;
    @Column(name = "POSTALCODE")
    private String postalCode;
    @Column(name = "CITY")
    private String city;

    public User() {
    }

    public User(String name, String password, String role, String inss, String lastName,
                String firstName, String street, String houseNumber, String postalCode, String city) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.inss = inss;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getInss() {
        return inss;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public String getRole() {
        return role;
    }


}
