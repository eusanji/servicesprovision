package com.servicesprovision;

import com.servicesprovision.model.entity.Client;
import com.servicesprovision.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SellsApplication  {

    @Bean
    public CommandLineRunner run( @Autowired ClientRepository clientsRepository){
       return args-> {
           Client client = Client.builder()
                   .name("Joao")
                   .cpf("12345678912")
                   .build();
           clientsRepository.save(client);
        };
    }


    @Autowired
    @Value("${applicationName}")
    public String applicationName;

    @GetMapping("/hello")
    public String helloWorld(){
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(SellsApplication.class, args);
        System.out.println();

            }
}
