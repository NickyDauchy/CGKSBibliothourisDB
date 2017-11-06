package be.cegeka.bibliothouris.domain.users;

import org.springframework.test.util.ReflectionTestUtils;

public class UserTestBuilder {

    private String name;
    private int id;
    private String password;

    public static UserTestBuilder aUser() {
        return new UserTestBuilder()
                .withName("Seppe").withPassWord("Password");
    }

    public User build() {
        User user = new User(name, password, "USER");
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

}
