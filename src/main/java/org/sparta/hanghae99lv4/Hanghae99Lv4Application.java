package org.sparta.hanghae99lv4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hanghae99Lv4Application {

    public static void main(String[] args) {
        SpringApplication.run(Hanghae99Lv4Application.class, args);
    }

}
