package kopylove.heap.e70a;

import jakarta.persistence.EntityManager;
import kopylove.heap.b505.EntityManagerProvider;
import org.junit.jupiter.api.AfterEach;

public class EntityManagerSession
{
    @AfterEach
    public void destroy()
    {
        EntityManagerProvider.closeEntityManager();
    }

    public EntityManager getEntityManager()
    {
        return EntityManagerProvider.getEntityManager();
    }
}
