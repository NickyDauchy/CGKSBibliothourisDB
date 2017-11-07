package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
@Transactional
public class UserController {

    @Inject
    private UserService userService;

    @GetMapping
    @Secured({"ROLE_ADMIN"})
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void addRegisteredUser(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "password", required = false) String password,
                        @RequestParam(value = "inss", required = true) String inss,
                        @RequestParam(value = "lastname", required = true) String lastname,
                        @RequestParam(value = "firstname", required = false) String firstname,
                        @RequestParam(value = "street", required = false) String street,
                        @RequestParam(value = "housenumber", required = false) String housenumber,
                        @RequestParam(value = "postalcode", required = false) String postalcode,
                        @RequestParam(value = "city", required = true) String city  ) {
        userService.addUser(name, password,inss, lastname,firstname,street,housenumber,postalcode,city);
    }
}
