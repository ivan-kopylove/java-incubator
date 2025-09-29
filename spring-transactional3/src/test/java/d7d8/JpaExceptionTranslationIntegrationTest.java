package d7d8;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@DataJpaTest
class JpaExceptionTranslationIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void whenConstraintViolation_thenTranslatedToDataIntegrityViolationException() {
        User user1 = new User("john@example.com", "John");
        User user2 = new User("john@example.com", "John"); // Same email - should violate unique constraint
        
        userRepository.save(user1);
        
        // This should throw a translated exception
        assertThrows(DataIntegrityViolationException.class, () -> {
            userRepository.save(user2);
        });
    }

    @Test
    void whenOptimisticLockingConflict_thenTranslatedToOptimisticLockingFailureException() {
        User user = userRepository.save(new User("test@example.com", "Test"));
        
        // Simulate optimistic locking conflict
        User user1 = entityManager.find(User.class, user.getId());
        User user2 = entityManager.find(User.class, user.getId());
        
        user1.setName("Updated1");
        user2.setName("Updated2");
        
        userRepository.save(user1);
        
        // This should cause optimistic locking exception
        assertThrows(OptimisticLockingFailureException.class, () -> {
            userRepository.save(user2);
        });
    }

    @Entity
    @Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
    static class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @Column(unique = true)
        private String email;
        
        private String name;
        
        @Version
        private Long version;

        public User() {}

        public User(String email, String name) {
            this.email = email;
            this.name = name;
        }

        // getters and setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public Long getVersion() { return version; }
        public void setVersion(Long version) { this.version = version; }
    }

    interface UserRepository extends JpaRepository<User, Long>
    {
    }
}