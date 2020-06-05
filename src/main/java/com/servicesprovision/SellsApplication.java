package com.servicesprovision;

import com.servicesprovision.model.entity.Client;
import com.servicesprovision.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
                   .cpf("48191096005")
                   .build();
           clientRepository.save(client);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SellsApplication.class, args);
    }
}
