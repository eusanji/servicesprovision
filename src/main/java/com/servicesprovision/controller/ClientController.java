package com.servicesprovision.controller;

import com.servicesprovision.model.entity.Client;
import com.servicesprovision.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save( @RequestBody Client client){
        return clientRepository.save(client);
    }

    @GetMapping("{id}")
    public Client findById(@PathVariable Integer id){
        return clientRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        clientRepository
                 .findById(id)
                 .map(client -> {
                     clientRepository.delete(client);
                     return Void.TYPE;
                 })
                 .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateById(@PathVariable Integer id, @RequestBody Client updatedClient){
        clientRepository
                .findById(id)
                .map(client -> {
                    updatedClient.setId(client.getId());
                    return clientRepository.save(updatedClient);
                })
                .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
}
