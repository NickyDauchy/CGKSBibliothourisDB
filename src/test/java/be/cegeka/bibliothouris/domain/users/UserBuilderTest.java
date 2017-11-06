package be.cegeka.bibliothouris.domain.users;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserBuilderTest {

    private User testUser;
    private User testLibrarian;
    private User testFullUser;

    @Before
    public void setUp() throws Exception {
        UserBuilder userBuilder = new UserBuilder();
        testUser = userBuilder.withName("Ralph").withPassWord("abc").withUserRole().build();
        testFullUser = userBuilder.withName("Ralph")
                .withPassWord("abc")
                .withUserRole()
                .withLastname("Narwhal")
                .withFirstname("digidi")
                .withInss("1515")
                .withCity("Nope")
                .withPostalCode("2585")
                .withHouseNumber("69")
                .withStreet("Denied")
                .buildFull();
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

    @Test
    public void withId_shouldAddIDtoCreatedUser() throws Exception {
        assertThat(testUser.getId()).isEqualTo(testUser.getId());

    }

    @Test
    public void getInfoOfFullUser_ReturnCityName() throws Exception {
        assertThat(testFullUser.getCity()).isEqualTo("Nope");
    }

    @Test
    public void getInfoOfFullUser_ReturnHouseNumber() throws Exception {
        assertThat(testFullUser.getHouseNumber()).isEqualTo("69");
    }

    @Test
    public void getInfoOfFullUser_ReturnStreet() throws Exception {
        assertThat(testFullUser.getStreet()).isEqualTo("Denied");
    }

    @Test
    public void getInfoOfFullUser_ReturnLastName() throws Exception {
        assertThat(testFullUser.getLastName()).isEqualTo("Narwhal");
    }

    @Test
    public void getInfoOfFullUser_ReturnFirstName() throws Exception {
        assertThat(testFullUser.getFirstName()).isEqualTo("digidi");
    }

    @Test
    public void getInfoOfFullUser_ReturnPostalCode() throws Exception {
        assertThat(testFullUser.getPostalCode()).isEqualTo("2585");
    }

    @Test
    public void gettingAllInfoOfUser_shouoldReturnINSS() throws Exception {
        assertThat(testFullUser.getInss()).isEqualTo("1515");
    }

}