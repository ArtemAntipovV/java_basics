package com.skillbox.fibonacci;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FibonacciRepositoryTest extends PostgresTestContainerInitializer {


    @Autowired
    FibonacciRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EntityManager entityManager;


    @BeforeAll
    public static void beforeAll() {
        postgres.start();
    }
    @AfterAll
    public static void afterAll() {
        postgres.stop();
    }

    @Test
    @DisplayName("Test save number in database")
    public void testSaveFibonacciNumbersDataBase() {
        FibonacciNumber number = new FibonacciNumber(1, 1);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);
        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 1",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );
        assertEquals(number.getIndex(), actual.get(0).getIndex());
        assertEquals(number.getValue(), actual.get(0).getValue());
        assertEquals(1, actual.size());
    }

    @Test
    @DisplayName("Test find by index")
    public void testFindByIndex() {
        repository.save(new FibonacciNumber(1,1));
        Optional<FibonacciNumber> optionalFound = repository.findByIndex(1);
        assertTrue(optionalFound.isPresent());
        FibonacciNumber found = optionalFound.get();
        assertEquals(1, found.getValue());
    }

    @Test
    @DisplayName("Duplicate test")
    public void testNoExceptionsOrDuplicatesOnSameNumberInsert() {
        FibonacciNumber number = new FibonacciNumber(3, 2);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);

        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 3",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );
        assertEquals(1, actual.size());

        repository.save(number);
        entityManager.flush();
        List<FibonacciNumber> actualAfterDuplicateInsert = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 3",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );
        assertEquals(1, actualAfterDuplicateInsert.size());

    }

}


