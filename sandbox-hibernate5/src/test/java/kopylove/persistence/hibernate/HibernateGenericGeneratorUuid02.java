package kopylove.persistence.hibernate;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/// [...](https://docs.jboss.org/hibernate/core/3.6/reference/en-US/html/mapping.html#d0e5294)
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

        assertNotNull(generatedKey.getKey());
        assertInstanceOf(String.class, generatedKey.getKey());
        assertEquals(36, generatedKey.getKey().length());
    }
}
