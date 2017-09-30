package ch.bullsoft.springtesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApiIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void checkStringResponse_withTestRestTemplate() {
        String response = testRestTemplate.getForObject("/api/info", String.class);
        assertEquals("{\"status\":\"OK\"}", response);
    }
}
