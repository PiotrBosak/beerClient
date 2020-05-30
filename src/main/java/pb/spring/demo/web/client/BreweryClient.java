package pb.spring.demo.web.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pb.spring.demo.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "pb.spring.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apiHost;
    private final RestTemplate restTemplate;

    @Autowired//since it's constructor injection it is not needed
    public BreweryClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;

    }

    public BeerDto getBeerById(UUID id) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + id.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
    }
    public void updateBeer(UUID id, BeerDto dto){
        restTemplate.put(apiHost+BEER_PATH_V1+id.toString(),dto);
    }
    public void deleteBeer(UUID id){
        restTemplate.delete(apiHost+BEER_PATH_V1+id.toString());
    }

}
