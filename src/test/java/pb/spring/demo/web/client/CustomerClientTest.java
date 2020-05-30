package pb.spring.demo.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pb.spring.demo.web.model.CustomerDto;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerClientTest {

    @Autowired
    private CustomerClient client;
    @Test
    void getCustomer() {
        var customer = client.getCustomer(UUID.randomUUID());
        assertNotNull(customer);
    }

    @Test
    void saveNewCustomer() {
        var customer = CustomerDto.builder().
                name("name").
                build();
        var location = client.saveNewCustomer(customer);
        assertNotNull(location);
    }

    @Test
    void putCustomer() {
        var customer = CustomerDto.builder().
                name("name").
                build();
        client.putCustomer(UUID.randomUUID(),customer);

    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}