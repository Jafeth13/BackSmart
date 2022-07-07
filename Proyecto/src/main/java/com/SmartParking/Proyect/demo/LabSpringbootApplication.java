package com.SmartParking.Proyect.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@RestController
//@SpringBootApplication(exclude ={
//        DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class
//})


@SpringBootApplication(scanBasePackages = { "com.SmartParking.Proyect.*" })
@ComponentScan({ "com.SmartParking.Proyect.controller","com.SmartParking.Proyect.repository", "com.SmartParking.Proyect.service" } )
@EntityScan("com.SmartParking.Proyect.domain")
@EnableJpaRepositories("com.SmartParking.Proyect.repository")

public class LabSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSpringbootApplication.class, args);
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(value = "myName",defaultValue = "World") String name){
        return String.format("Hello %s!", name);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }

}
