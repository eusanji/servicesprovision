package com.servicesprovision.service;

import com.servicesprovision.model.entity.Client;
import com.servicesprovision.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
    @Autowired
    public ClientsRepository repository;

    public void saveClient(Client client){
        validateClient(client);
        repository.persist(client);

    }

    public void validateClient(Client client){

    }
}
