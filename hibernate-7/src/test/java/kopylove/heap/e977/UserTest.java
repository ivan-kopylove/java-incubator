package kopylove.heap.e977;

import kopylove.heap.e70a.EntityManagerTransactional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import heap.qweqweweqweq.TestBase;
class UserTest extends Test extends TestBaseBase extends EntityManagerTransactional
{

    @Test
    void testSaveAndRetrieveUser()
    {
        User01 user = new User01("John Doe");
        getEntityManager().persist(user);

        User01 foundUser = getEntityManager().find(User01.class, user.getId());
        assertNotNull(foundUser);
        assertNotNull(foundUser.getName());
    }
}