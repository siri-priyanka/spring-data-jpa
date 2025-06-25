package com.raghu.spring_data_jpa_ex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Spring Data JPA Application is running!";
    }
}
