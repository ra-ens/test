package com.abdelhakimrafik.customerservice.commands.controllers;

import com.abdelhakimrafik.commonapi.queries.CustomerQuery;
import com.abdelhakimrafik.customerservice.commands.services.CustomerCommandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin("*")
@RequestMapping("/cmd/customers")
@AllArgsConstructor
public class CustomerCommandController {

    private CustomerCommandService customerService;

    @PostMapping
    public CompletableFuture<String> createCustomer(@RequestBody CustomerQuery.CreateCustomer query) {
        return this.customerService.createCustomer(query);
    }

    @PutMapping
    public CompletableFuture<String> updateCustomer(@RequestBody CustomerQuery.UpdateCustomer query) {
        return this.customerService.updateCustomer(query);
    }

    @DeleteMapping
    public CompletableFuture<String> deleteCustomer(@PathVariable String id){
        return this.customerService.deleteCustomer(new CustomerQuery.DeleteCustomer(id));
    }
}
