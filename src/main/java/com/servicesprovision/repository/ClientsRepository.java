package com.servicesprovision.repository;

import com.servicesprovision.model.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientsRepository {
    public void persist(Client client) {
        //access the bd and saves a client
    }
}
