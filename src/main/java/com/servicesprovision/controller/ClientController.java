package com.servicesprovision.controller;

import com.servicesprovision.model.entity.Client;
import com.servicesprovision.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

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
    public Client save( @RequestBody @Valid Client client){
        return clientRepository.save(client);
    }

    @GetMapping("{id}")
    public Client findById(@PathVariable Integer id){
        return clientRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client does not exist"));
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
                 .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client does not exist"));
    }
    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Client Updated")
    public void updateById(@PathVariable Integer id, @RequestBody @Valid Client updatedClient){
        clientRepository
                .findById(id)
                .map(client -> {
                    updatedClient.setId(client.getId());
                    return clientRepository.save(updatedClient);
                })
                .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client does not exist"));

    }
}
