package be.cegeka.bibliothouris.domain.users;

import org.springframework.test.util.ReflectionTestUtils;

public class UserTestBuilder {

    private String name;
    private int id;
    private String password;
    private String role;
    private String inss;
    private String lastname;
    private String firstname;
    private String street;
    private String houseNumber;
    private String postalCode;
    private String city;

    public static UserTestBuilder aUser() {
        return new UserTestBuilder()
                .withName("Seppe")
                .withPassWord("Password")
                .withInns("12335")
                .withLastName("Gielen")
                .withCity("Leuven");
    }

    public User build() {
        User user = new User(name, password, "USER",inss,lastname,firstname,street,houseNumber,postalCode,city);
        ReflectionTestUtils.setField(user, "id", id);
        return user;
    }

    public UserTestBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserTestBuilder withName(String name) {
        this.name = name;
        return this;
    }


    public UserTestBuilder withPassWord(String password) {
        this.password = password;
        return this;
    }

    public UserTestBuilder withInns(String inss) {
        this.inss = inss;
        return this;
    }

    public UserTestBuilder withLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserTestBuilder withCity(String city) {
        this.city = city;
        return this;
    }


}
