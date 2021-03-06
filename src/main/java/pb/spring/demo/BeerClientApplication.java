package pb.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"pb.spring"})
public class BeerClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerClientApplication.class, args);
    }

}
