package loi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RemoteController {

    @GetMapping("/remote")
    public ResponseEntity<String> remote() {
        return ResponseEntity.ok("remote returned!!");
    }

}
