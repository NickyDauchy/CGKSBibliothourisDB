package be.cegeka.bibliothouris.domain.users;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static be.cegeka.bibliothouris.domain.users.UserTestBuilder.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setup() {
        user = aUser()
                .withName("Seppe")
                .withId(10)
                .build();
    }

    @Test
    public void equals_SameObject_IsTrue() throws Exception {
        assertThat(user).isEqualTo(user);
    }

    @Test
    public void equals_ObjectWithSameIdAndName_IsTrue() throws Exception {
        assertThat(user).isEqualTo(aUser()
                .withId(10)
                .withName("Seppe")
                .build()
        );
    }

    @Test
    public void equals_NullObject_IsFalse() throws Exception {
        assertThat(user).isNotEqualTo(null);
    }

    @Test
    public void equals_OtherClass_IsFalse() throws Exception {
        assertThat(user).isNotEqualTo(new Object());
    }

    @Test
    public void equals_ObjectWithOtherId_IsFalse() throws Exception {
        assertThat(user).isNotEqualTo(aUser()
                .withId(9)
                .withName("Seppe")
                .build());
    }

    @Test
    public void equals_ObjectWithOtherName_IsFalse() throws Exception {
        assertThat(user).isNotEqualTo(aUser()
                .withId(10)
                .withName("Other")
                .build());
    }

    @Test
    public void equals_ObjectWithNullName_IsFalse() throws Exception {
        assertThat(user).isNotEqualTo(aUser()
                .withId(10)
                .withName(null)
                .build());
    }

    @Test
    public void equals_ObjectWithBothNullName_IsTrue() throws Exception {
        assertThat(aUser()
                .withId(10)
                .withName(null)
                .build())
                .isEqualTo(aUser()
                        .withId(10)
                        .withName(null)
                        .build());
    }

    @Test
    public void equals_ObjectWithNoNullName_IsFalse() throws Exception {
        assertThat(aUser()
                .withId(10)
                .withName(null)
                .build()).
                isNotEqualTo(aUser()
                        .withId(10)
                        .withName("Seppe")
                        .build());
    }

}