package br.com.danielbrai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.danielbrai.infrastructure", "br.com.danielbrai.core"})
public class App{

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}