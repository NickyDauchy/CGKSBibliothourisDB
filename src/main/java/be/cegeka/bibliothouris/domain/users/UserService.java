package be.cegeka.bibliothouris.domain.users;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class UserService {

    @Inject
    private UserRepository userRepository;

    public void addUser(String name, String password){
        userRepository.addUser(new User(name, password));
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
