package com.abdelhakimrafik.customerservice.queries.repositories;

import com.abdelhakimrafik.customerservice.queries.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
