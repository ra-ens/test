package com.abdelhakimrafik.customerservice.commands.services;

import com.abdelhakimrafik.commonapi.commands.CustomerCommand;
import com.abdelhakimrafik.commonapi.queries.CustomerQuery;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Transactional
@AllArgsConstructor
public class CustomerCommandService {

    private CommandGateway gateway;

    public CompletableFuture<String> createCustomer(CustomerQuery.CreateCustomer query) {
        return gateway.send(new CustomerCommand.CreateCustomer(
                UUID.randomUUID().toString(),
                query.getName(),
                query.getAddress(),
                query.getEmail(),
                query.getPhone()
        ));
    }

    public CompletableFuture<String> updateCustomer(CustomerQuery.UpdateCustomer query) {
        return gateway.send(new CustomerCommand.UpdateCustomer(
                query.getId(),
                query.getName(),
                query.getAddress(),
                query.getEmail(),
                query.getPhone()
        ));
    }

    public CompletableFuture<String> deleteCustomer(CustomerQuery.DeleteCustomer query) {
        return gateway.send(new CustomerCommand.DeleteCustomer(query.getId()));
    }
}
