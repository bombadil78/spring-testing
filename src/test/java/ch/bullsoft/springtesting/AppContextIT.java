package ch.bullsoft.springtesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppContextIT {

    @MockBean
    private InfoResource infoResource;

    @Test
	public void contextLoads() {

    }

    @Test
    public void applicationContext_loadMockBeans() {
        assertNotNull(infoResource);
    }
}
