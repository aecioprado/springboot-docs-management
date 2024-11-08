package com.aecioprado.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BaseController {

    @RequestMapping("/hello-world")
    public ResponseEntity<String> helloWorld() {
        log.info("Acessing hello-world endpoint");
        return ResponseEntity.ok("Hello World");
    }
}
