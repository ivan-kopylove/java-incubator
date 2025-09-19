package kopylove.heap.dsasdasda;

import org.junit.jupiter.api.AfterEach;

import static kopylove.heap.EntityManagerProvider.closeEntityManager;

public class EntityManagerSession
{
    @AfterEach
    public void destroy()
    {
        closeEntityManager();
    }
}
