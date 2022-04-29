package com.meli.mutant.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.meli.mutant.api","com.meli.mutant.controller","com.meli.mutant.service.impl","com.meli.mutant.search.impl"})
@EnableJpaRepositories("com.meli.mutant.repository")
@EntityScan("com.meli.mutant.model")
@Component
public class PruebaApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PruebaApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(PruebaApplication.class, args);
        System.out.println("********* Se inicia la aplicacion correctamente ****************");
    }
}
