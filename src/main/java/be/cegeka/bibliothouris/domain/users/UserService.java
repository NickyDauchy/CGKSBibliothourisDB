package be.cegeka.bibliothouris.domain.users;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UserService {

    @Inject
    private UserRepository userRepository;


    public void addUser(String name, String password,String inss, String lastname, String firstname,String street, String housenumber,String postalcode, String city){
        UserBuilder userBuilder = new UserBuilder();
        userRepository.addUser(userBuilder.withName(name)
                .withPassWord(password)
                .withUserRole()
                .withInss(inss)
                .withFirstname(firstname)
                .withLastname(lastname)
                .withStreet(street)
                .withHouseNumber(housenumber)
                .withCity(city)
                .withPostalCode(postalcode)
                .buildFull());
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
