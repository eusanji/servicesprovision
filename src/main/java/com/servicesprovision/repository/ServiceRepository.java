package com.servicesprovision.repository;

import com.servicesprovision.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer> {

}
