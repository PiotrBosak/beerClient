package pb.spring.demo.web.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.UUID;

@SpringBootTest
class BreweryClientTest {


    @Autowired
    BreweryClient client;

    @Test
    void getById() {
        var dto = client.getBeerById(UUID.randomUUID());
        Assertions.assertNotNull(dto);
    }

}