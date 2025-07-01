package com.awsDeploy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/vikash")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello vikash I'm running on AWS Deploy!");
    }
}
