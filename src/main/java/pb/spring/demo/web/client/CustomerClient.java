package pb.spring.demo.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pb.spring.demo.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties("pb.spring.customer.brewery")
public class CustomerClient {
    private String apiHost;
    public static final String CUSTOMER_PATH  ="/api/customer/";
    private final RestTemplate template;

    public CustomerClient(RestTemplateBuilder builder) {
        this.template = builder.build();
    }
    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public CustomerDto getCustomer(UUID id){
        return template.getForObject(apiHost+CUSTOMER_PATH+id.toString(),CustomerDto.class);
    }
    public URI saveNewCustomer(CustomerDto dto){
        return template.postForLocation(apiHost+CUSTOMER_PATH,dto);
    }
    public void putCustomer(UUID id,CustomerDto dto){
        template.put(apiHost+CUSTOMER_PATH+id.toString(),dto);
    }
    public void deleteCustomer(UUID id){
        template.delete(apiHost+CUSTOMER_PATH+id.toString());
    }

}
