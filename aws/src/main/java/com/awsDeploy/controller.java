package com.awsDeploy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/Test")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from AWS Deploy!");
    }
}
