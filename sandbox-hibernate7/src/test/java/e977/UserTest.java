package e977;

import dasdsa.EntityManagerBuilder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest
{
    private EntityManager entityManager;

    @BeforeEach
    void setUp()
    {
        entityManager = EntityManagerBuilder.getEntityManager(List.of(User.class));
    }

    @AfterEach
    void tearDown()
    {
        EntityManagerBuilder.close();
    }

    @Test
    void testSaveAndRetrieveUser()
    {
        entityManager.getTransaction().begin();

        User user = new User("John Doe");
        entityManager.persist(user);

        entityManager.getTransaction().commit();

        User foundUser = entityManager.find(User.class, user.getId());
        assertNotNull(foundUser);
        assertNotNull(foundUser.getName());
    }

    @Entity
    @Table(name = "users")
    public static class User
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        private String name;

        // Constructors, getters, and setters
        public User() {}

        public User(String name)
        {
            this.name = name;
        }

        // Getters and setters
        public Long getId() {return id;}

        public String getName() {return name;}

        public void setName(String name) {this.name = name;}
    }
}