package kopylove.heap.e977;

import kopylove.heap.e70a.EntityManagerSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest extends EntityManagerSession
{

    @Test
    void testSaveAndRetrieveUser()
    {
        getEntityManager().getTransaction().begin();

        User01 user = new User01("John Doe");
        getEntityManager().persist(user);

        getEntityManager().getTransaction().commit();

        User01 foundUser = getEntityManager().find(User01.class, user.getId());
        assertNotNull(foundUser);
        assertNotNull(foundUser.getName());
    }
}