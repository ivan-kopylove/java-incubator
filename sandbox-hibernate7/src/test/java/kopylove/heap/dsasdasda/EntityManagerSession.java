package kopylove.heap.dsasdasda;

import jakarta.persistence.EntityManager;
import kopylove.heap.EntityManagerProvider;
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
