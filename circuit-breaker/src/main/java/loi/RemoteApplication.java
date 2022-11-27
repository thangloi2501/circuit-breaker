package loi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
class CBApplication {

    public static void main(String[] args) {
        SpringApplication.run(CBApplication.class, args);
    }

    @Bean
    RestTemplate getRestTemplate() {return new RestTemplate();}

}
