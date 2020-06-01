package com.servicesprovision;

import com.servicesprovision.model.entity.Client;
import com.servicesprovision.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SellsApplication  {

    @Bean
    public CommandLineRunner run( @Autowired ClientRepository clientRepository){
       return args-> {
           Client client = Client.builder()
                   .name("Joao")
                   .cpf("12345678912")
                   .build();
           clientRepository.save(client);
        };
    }

    @Autowired
    @Value("${applicationName}")
    public String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(SellsApplication.class, args);
    }
}
