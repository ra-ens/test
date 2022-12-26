package com.abdelhakimrafik.customerservice.queries.services;

import com.abdelhakimrafik.commonapi.queries.CustomerQuery;
import com.abdelhakimrafik.customerservice.queries.entities.Client;
import com.abdelhakimrafik.customerservice.queries.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CustomerQueryService {

    private ClientRepository repository;

    @QueryHandler
    public List<Client> getAllCustomers(CustomerQuery.GetAllCustomers query) {
        return repository.findAll();
    }

    @QueryHandler
    public Client getCustomerById(CustomerQuery.GetCustomerById query) {
        return repository.findById(query.getId()).get();
    }
}
