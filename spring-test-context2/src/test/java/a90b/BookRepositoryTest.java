package a90b;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Default, JPA tests data are transactional and roll back at the end of each test.
@DataJpaTest
public class BookRepositoryTest {

    // Alternative for EntityManager
    // Optional in this case, we can use bookRepository to do the same stuff
    @Autowired
    private TestEntityManager         testEM;
    @Autowired
    private BookRepository bookRepository;

    // Need clean up if the MainApplication CommandLineRunner bean inserted some data
    // empty table.
    @BeforeEach
    void cleanup() {
        bookRepository.deleteAll();
        bookRepository.flush();
        testEM.clear();
    }

    @Test
    public void testSave() {

        Book b1 = new Book("Book A", BigDecimal.valueOf(9.99), LocalDate.of(2023, 8, 31));

        //testEM.persistAndFlush(b1); the same
        bookRepository.save(b1);

        Long savedBookID = b1.getId();

        Book book = bookRepository.findById(savedBookID).orElseThrow();
        // Book book = testEM.find(Book.class, savedBookID);

        assertEquals(savedBookID, book.getId());
        assertEquals("Book A", book.getTitle());
        assertEquals(BigDecimal.valueOf(9.99), book.getPrice());
        assertEquals(LocalDate.of(2023, 8, 31), book.getPublishDate());


    }

}