package ch.bullsoft.springtesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void save() {
        Movie movie = new Movie();
        movie.setName("foobar");

        assertNull(movie.getId());
        movieRepository.save(movie);
        assertNotNull(movie.getId());
    }

    @Test(expected = ConstraintViolationException.class)
    public void save_failsIfNameIsTooLong() {
        Movie movie = new Movie();
        movie.setName("000000000000000000000000000000");

        assertNull(movie.getId());
        movieRepository.save(movie);
    }

    @Test
    public void findAll() {
        Movie m1 = new Movie();
        m1.setName("m1");
        Movie m2 = new Movie();
        m2.setName("m2");
        entityManager.persist(m1);
        entityManager.persist(m2);

        List<Movie> movies = movieRepository.findAll();
        assertEquals(2, movies.size());
    }
}
