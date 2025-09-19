package heap.e977;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static heap.EntityManagerProvider.getEntityManager;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest
{
    @BeforeEach
    void setUp()
    {
        
    }

    @Test
    void testSaveAndRetrieveUser()
    {
        getEntityManager().getTransaction().begin();

        User user = new User("John Doe");
        getEntityManager().persist(user);

        getEntityManager().getTransaction().commit();

        User foundUser = getEntityManager().find(User.class, user.getId());
        assertNotNull(foundUser);
        assertNotNull(foundUser.getName());
    }
}