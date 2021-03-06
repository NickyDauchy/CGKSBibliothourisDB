package be.cegeka.bibliothouris.domain.users;

import be.cegeka.bibliothouris.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

import static be.cegeka.bibliothouris.domain.users.UserTestBuilder.aUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@Transactional
public class UserRepositoryTest {

    @Inject
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;
    private UserBuilder userBuilder= new UserBuilder();

    private User seppe, kiki,user, librarian, admin;

    @Before
    public void setup(){
        seppe = aUser().withName("Seppe").withInns("123").withCity("leuven").withLastName("Gielen").build();
        kiki = aUser().withName("Kiki").withInns("12533").withCity("leuven").withLastName("Willems").build();

        entityManager.persist(seppe);
        entityManager.persist(kiki);
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = userRepository.getAllUsers();
        Query query = entityManager.createQuery("select u from User u");

        user = userRepository.getUserByName("USER");
        librarian = userRepository.getUserByName("LIBRARIAN");
        admin = userRepository.getUserByName("ADMIN");

        assertThat( query.getResultList()).containsOnly(seppe,kiki,user,librarian,admin);
    }

    @Test
    public void getUserByName(){
        User actual = userRepository.getUserByName("Seppe");

        assertThat(actual).isEqualTo(seppe);
    }

    @Test
    public void getUserByName_NoUserFound(){
        assertThatThrownBy(()-> { userRepository.getUserByName("Seppe2"); } ).isInstanceOf(NoResultException.class);
    }

    @Test
    public void getUserByName_NoUniqueUserFound(){
        entityManager.persist(aUser().withName("Seppe").build());

        assertThatThrownBy(()-> { userRepository.getUserByName("Seppe"); } ).isInstanceOf(NonUniqueResultException.class);
    }

    @After
    public void teardown(){
        entityManager.clear();
    }

}