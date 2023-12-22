package com.example.myup.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account extends AbstractEntity {

    private Long accountNumber;

    @Min(value = 100, message = "account.balance")
    private Double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user id")
    private User user;

    @OneToMany(mappedBy = "account", targetEntity = Transaction.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transaction> transaction;
//    private Card card;
//    private List<Transaction> transactions;
}
