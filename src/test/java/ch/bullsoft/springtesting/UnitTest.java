package ch.bullsoft.springtesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UnitTest {

    @Mock
    private InfoResource infoResource;

    @InjectMocks
    private MovieResource movieResource;

    @Mock
    private MovieRepository movieRepository;

    @Test
    public void simpleTest() {
        assertTrue(true);
    }

    @Test
    public void withoutMockitoAnnotation() {
        InfoResource customInfoResource = Mockito.mock(InfoResource.class);
        assertNotNull(customInfoResource);
    }

    @Test
    public void usingMockitosMockAnnotation() {
        assertNotNull(infoResource);
    }

    @Test
    public void injectTheMocks() {
        assertNotNull(movieResource);
        assertNotNull(movieResource.getMovieRepository());
    }

    @Test
    public void mockSetup_expectData() {
        Movie m1 = new Movie();
        Movie m2 = new Movie();
        m1.setName("m1");
        m2.setName("m2");
        when(movieRepository.findAll()).thenReturn(Arrays.asList(m1, m2));
        assertEquals(2, movieResource.getAll().size());
    }

    @Test
    public void mockSetup_expectException() {
        when(movieRepository.findAll()).thenThrow(Exception.class);
        assertEquals(0, movieResource.getAll().size());
    }

}
