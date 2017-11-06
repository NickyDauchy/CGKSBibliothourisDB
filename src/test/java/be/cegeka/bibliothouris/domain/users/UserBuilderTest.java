package be.cegeka.bibliothouris.domain.users;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class UserBuilderTest {

   private UserBuilder userBuilder;
   private User testUser;
   private User testLibrarian;

    @Before
    public void setUp() throws Exception {
        userBuilder = new UserBuilder();
        testUser = userBuilder.withName("Ralph").withPassWord("abc").withUserRole().build();
        userBuilder = new UserBuilder();
        testLibrarian = userBuilder.withName("Erwin").withPassWord("cba").withLibrarianRole().build();
    }

    @Test
    public void withName_givenName_shouldAddNameToCreatedUser() throws Exception {
        assertThat(testUser.getName()).isEqualTo("Ralph");
        assertThat(testLibrarian.getName()).isEqualTo("Erwin");
    }

    @Test
    public void withPassword_givenPassword_shouldAddPasswordToCreatedUser() throws Exception {
        assertThat(testUser.getPassword()).isEqualTo("abc");
        assertThat(testLibrarian.getPassword()).isEqualTo("cba");
    }

    @Test
    public void withUserRole_shouldOnlyGiveUserRoleToCreatedUser() throws Exception {
        assertThat(testUser.getRole()).isEqualTo("USER");
    }

    @Test
    public void withLibrarianRole_shouldGiveUserAndLibrarianRoleToCreatedUser() throws Exception {
        assertThat(testLibrarian.getRole()).isEqualTo("LIBRARIAN");
    }
}