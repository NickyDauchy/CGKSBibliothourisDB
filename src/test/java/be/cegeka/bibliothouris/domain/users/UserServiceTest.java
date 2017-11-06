package be.cegeka.bibliothouris.domain.users;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private UserBuilder userBuilder;

    @Before
    public void setUp() throws Exception {
        userBuilder = new UserBuilder();
    }


    @Test
    public void addUser_ShouldCallUserRepository() throws Exception {
        userService.addUser("Seppe", "password");

        verify(userRepository).addUser(userBuilder.withName("Seppe").withPassWord("password").withUserRole().build());
    }

    @Test
    public void getAllUsers() throws Exception {
        User user1 = userBuilder.withName("Seppe").withPassWord("password").withUserRole().build();
        User user2 = userBuilder.withName("Sanne").withPassWord("password").withUserRole().build();
        User user3 = userBuilder.withName("Xan").withPassWord("password").withUserRole().build();

        when(userRepository.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        assertThat(userService.getAllUsers()).containsOnly(user1, user2);
    }
}