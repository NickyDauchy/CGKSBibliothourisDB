package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void whenAddUser_shouldActivateUserService() throws Exception {
        userController.addRegisteredUser("Seppe",
                "password",
                "INSS",
                "Dauchy",
                "Nicky",
                "whatever",
                "11",
                "2840",
                "Muizen");
        verify(userService).addUser("Seppe",
                "password",
                "INSS",
                "Dauchy",
                "Nicky",
                "whatever",
                "11",
                "2840",
                "Muizen");
    }

    @Test
    public void whenGettingUsers_shouldReturnListOfAllUsers() throws Exception {
        User user1 = new User("jeroen", "jeroen", "ADMIN");
        User user2 = new User("len", "len", "LIBRARIAN");

        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));
        Assertions.assertThat(userController.getUsers()).containsOnly(user1, user2);
    }
}