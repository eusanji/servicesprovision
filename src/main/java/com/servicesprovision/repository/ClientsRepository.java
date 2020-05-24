package com.servicesprovision.repository;

import com.servicesprovision.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client,Integer> {

}
