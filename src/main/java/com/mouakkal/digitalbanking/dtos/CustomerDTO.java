package com.mouakkal.digitalbanking.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mouakkal.digitalbanking.entities.BankAccount;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
}
