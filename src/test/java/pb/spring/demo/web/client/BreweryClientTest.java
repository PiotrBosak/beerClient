package pb.spring.demo.web.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pb.spring.demo.web.model.BeerDto;


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

    @Test
    void saveNewBeer() {
        var dto = BeerDto.builder()
                .beerName("name")
                .beerStyle("style")
                .build();
        var location = client.saveNewBeer(dto);
        Assertions.assertNotNull(location);
        System.out.println(location);
    }
    @Test
    void putBeer(){
        var dto = BeerDto.builder()
                .beerName("name")
                .beerStyle("style")
                .build();
        client.updateBeer(UUID.randomUUID(),dto);
    }
    @Test
    void deleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }


}