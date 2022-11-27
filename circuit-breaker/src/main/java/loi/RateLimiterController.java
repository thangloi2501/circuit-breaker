package loi;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RateLimiterController {
    private static final String RETRY_TEST = "retryTest";
    @Autowired
    RestTemplate restTemplate1;

    @GetMapping("/rate")
    @RateLimiter(name = "rateLimiter")
    public ResponseEntity<String> test() throws InterruptedException {
        System.out.println("rate limiter......." + System.currentTimeMillis());
//        String response = restTemplate1.getForObject("http://localhost:8080/api/v1/remote", String.class);
//        Thread.sleep(1000);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }
}
