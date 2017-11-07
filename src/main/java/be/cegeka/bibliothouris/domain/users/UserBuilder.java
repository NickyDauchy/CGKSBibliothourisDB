package be.cegeka.bibliothouris.domain.users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserBuilder {

    private String name;
    private String password;
    private String role;
    private String inss;
    private String lastname;
    private String firstname;
    private String street;
    private String houseNumber;
    private String postalCode;
    private String city;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User buildFull() {
        User user = new User(name, password, role, inss,
                lastname, firstname, street,
                houseNumber, postalCode, city);
        return user;
    }

    public User build() {
        User user = new User(name, password, role);
        return user;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withPassWord(String password) {
        this.password = passwordEncoder.encode(password);
        return this;
    }

    public UserBuilder withInss(String inss) {
        this.inss = inss;
        return this;
    }

    public UserBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public UserBuilder withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public UserBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public UserBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public UserBuilder withUserRole() {
        this.role = "USER";
        return this;
    }

    public UserBuilder withLibrarianRole() {
        this.role = "LIBRARIAN";
        return this;
    }
}
