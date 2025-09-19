package kopylove.heap.dsasdasda;

import org.junit.jupiter.api.AfterEach;

import static kopylove.heap.EntityManagerProvider.closeEntityManager;

public class EntitiManagerSession
{
    @AfterEach
    public void destroy()
    {
        closeEntityManager();
    }
}
