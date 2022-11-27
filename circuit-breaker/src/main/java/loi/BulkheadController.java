package loi;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BulkheadController {
    private static final String RETRY_TEST = "retryTest";
    @Autowired
    RestTemplate restTemplate1;

    @GetMapping("/bulkhead")
    @Bulkhead(name = "bulkhead")
    public ResponseEntity<String> test() {
        System.out.println("Bulkhead......." + System.currentTimeMillis());
        String response = restTemplate1.getForObject("http://localhost:8080/api/v1/remote", String.class);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
