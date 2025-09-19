package kopylove.hibernate;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class HibernateGenericGeneratorUuid02
{
    @Test
    void what_does_this_example_demonstrate()
    {
        GeneratedValueUuid02 generatedKey = new GeneratedValueUuid02();

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(generatedKey);
        session.getTransaction().commit();
        session.close();

        assertNotNull(generatedKey.getId());
        assertInstanceOf(String.class, generatedKey.getId());
        assertEquals(36, generatedKey.getId().length());
    }
}
