package com.atvisited.atvisited;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtvisitedApplication {

    public static void main(String[] args) {
        // Load .env from project root
        Dotenv dotenv = Dotenv.configure()
                .directory("./") 
                .ignoreIfMissing()
                .load();


        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(AtvisitedApplication.class, args);
    }

}
