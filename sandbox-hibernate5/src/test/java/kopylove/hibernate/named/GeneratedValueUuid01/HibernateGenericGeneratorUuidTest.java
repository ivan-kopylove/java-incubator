package kopylove.hibernate.named.GeneratedValueUuid01;

import kopylove.hibernate.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class HibernateGenericGeneratorUuidTest
{
    @Test
    void what_does_this_example_demonstrate()
    {
        GeneratedValueUuid03 generatedKey = new GeneratedValueUuid03();

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(generatedKey);
        session.getTransaction().commit();
        session.close();

        assertNotNull(generatedKey.getId());
        assertInstanceOf(String.class, generatedKey.getId());
        assertEquals(32, generatedKey.getId().length());
    }
}
