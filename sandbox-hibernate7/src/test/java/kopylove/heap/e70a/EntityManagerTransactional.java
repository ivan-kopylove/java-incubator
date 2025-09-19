package kopylove.heap.e70a;

import jakarta.persistence.EntityManager;
import kopylove.heap.b505.EntityManagerProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class EntityManagerTransactional
{
    @BeforeEach
    public void init()
    {
        getEntityManager().getTransaction().begin();
    }

    @AfterEach
    public void destroy()
    {
        getEntityManager().getTransaction().commit();
        EntityManagerProvider.closeEntityManager();
    }

    public EntityManager getEntityManager()
    {
        return EntityManagerProvider.getEntityManager();
    }
}
