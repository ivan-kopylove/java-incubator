package e977;

import dasdsa.EntityManagerBuilder;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest
{
    private EntityManager entityManager;

    @BeforeEach
    void setUp()
    {
        entityManager = EntityManagerBuilder.getEntityManager(List.of(User.class));
    }

    @AfterEach
    void tearDown()
    {
        EntityManagerBuilder.close();
    }

    @Test
    void testSaveAndRetrieveUser()
    {
        entityManager.getTransaction().begin();

        User user = new User("John Doe");
        entityManager.persist(user);

        entityManager.getTransaction().commit();

        User foundUser = entityManager.find(User.class, user.getId());
        assertNotNull(foundUser);
        assertNotNull(foundUser.getName());
    }
}