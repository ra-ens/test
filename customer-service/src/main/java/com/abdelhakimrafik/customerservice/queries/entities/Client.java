package com.abdelhakimrafik.customerservice.queries.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Client {
    @Id
    private String id;
    private String name;
    private String address;
    private String email;
    private String phone;
}
