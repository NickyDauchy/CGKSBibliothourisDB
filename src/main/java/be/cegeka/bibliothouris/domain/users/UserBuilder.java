package be.cegeka.bibliothouris.domain.users;

public class UserBuilder {

    private String name;
    private int id;
    private String password;
    private String role;

    public User build(){
        User user = new User(name, password, role);
        return user;
    }

    public UserBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withPassWord(String password){
        this.password = password;
        return this;
    }

    public UserBuilder withUserRole(){
        this.role = "USER";
        return this;
    }

    public UserBuilder withLibrarianRole(){
        this.role = "LIBRARIAN";
       return this;
    }
}
