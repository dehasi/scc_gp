package me.dehasi.contracts.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootApplication
@ComponentScan
@Configuration
public class SccDemoApplication {

    @Value("${host}")
    String host;

    @Bean
    public RestTemplate restTemplate() {
        DefaultUriBuilderFactory defaultUriTemplateHandler = new DefaultUriBuilderFactory(host);
        return new RestTemplateBuilder().uriTemplateHandler(defaultUriTemplateHandler).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SccDemoApplication.class, args);
    }
}
