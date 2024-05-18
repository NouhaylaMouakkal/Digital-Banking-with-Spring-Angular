package com.mouakkal.digitalbanking.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
public class CreditDTO {
    private String accountId;
    private double amount;
    private String descritpion;
}