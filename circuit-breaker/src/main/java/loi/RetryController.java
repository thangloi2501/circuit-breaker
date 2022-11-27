package loi;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetryController {
    private static final String RETRY_TEST = "retryTest";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/retry")
    @Retry(name = "retryApi", fallbackMethod = "testFallback")
    public ResponseEntity<String> test() {
        System.out.println("Retry......." + System.currentTimeMillis());
        String response = restTemplate.getForObject("http://localhost:8080/api/v1/remote", String.class);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> testFallback(Exception ex) {
        return new ResponseEntity<String>("remote down", HttpStatus.OK);
    }
}
