package e977;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {
    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    void setUp() {
        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.url", "jdbc:h2:mem:test");
        properties.put("jakarta.persistence.jdbc.user", "sa");
        properties.put("jakarta.persistence.jdbc.password", "");
        properties.put("jakarta.persistence.schema-generation.database.action", "create-drop");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "false");
        properties.put("hibernate.use_sql_comments", "false");

        properties.put("hibernate.archive.autodetection", "class, hbm");

        emf = Persistence.createEntityManagerFactory("example-unit", properties);
        em = emf.createEntityManager();
    }

    @AfterEach
    void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    void testSaveAndRetrieveUser() {
        em.getTransaction().begin();
        
        User user = new User("John Doe");
        em.persist(user);
        
        em.getTransaction().commit();
        
        User foundUser = em.find(User.class, user.getId());
        assertNotNull(foundUser);
        assertNotNull(foundUser.getName());
    }
}