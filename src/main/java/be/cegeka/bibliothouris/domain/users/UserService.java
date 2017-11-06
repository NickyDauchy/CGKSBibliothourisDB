package be.cegeka.bibliothouris.domain.users;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UserService {

    @Inject
    private UserRepository userRepository;


    public void addUser(String name, String password){
        UserBuilder userBuilder = new UserBuilder();
        userRepository.addUser(userBuilder.withName(name).withPassWord(password).withUserRole().build());
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
