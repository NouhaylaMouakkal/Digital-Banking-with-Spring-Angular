package com.mouakkal.digitalbanking.dtos;

import com.mouakkal.digitalbanking.enumeration.OperationType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class AccountOperationDTO {

    private  Long id;
    private Date operationDate;
    private double amount;
    @Enumerated(EnumType.STRING)
    private OperationType type;
    private String description;
}
