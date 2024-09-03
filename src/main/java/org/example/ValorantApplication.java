package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ValorantApplication {
    public static void main(String[] args) {
        SpringApplication.run(ValorantApplication.class, args);
    }
}
