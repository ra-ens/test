package com.abdelhakimrafik.customerservice.queries.services;

import com.abdelhakimrafik.commonapi.events.CustomerEvent;
import com.abdelhakimrafik.customerservice.queries.entities.Client;
import com.abdelhakimrafik.customerservice.queries.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CustomerEventHandler {

    private ClientRepository clientRepository;

    @EventHandler
    public void onCustomerCreated(CustomerEvent.CustomerCreated event) {
        Client client = Client.builder()
                .id(event.getId())
                .name(event.getName())
                .address(event.getAddress())
                .email(event.getEmail())
                .phone(event.getPhone())
                .build();
        clientRepository.save(client);
    }

    @EventHandler
    public void onCustomerUpdated(CustomerEvent.CustomerUpdated event) {
        Client client = clientRepository.findById(event.getId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        if(event.getName() != "") client.setName(event.getName());
        if(event.getAddress() != "") client.setAddress(event.getAddress());
        if(event.getEmail() != "") client.setEmail(event.getEmail());
        if(event.getPhone() != "") client.setPhone(event.getPhone());

        clientRepository.save(client);
    }

    @EventHandler
    public void onCustomerDeleted(CustomerEvent.CustomerDeleted event) {
        clientRepository.deleteById(event.getId());
    }
}
