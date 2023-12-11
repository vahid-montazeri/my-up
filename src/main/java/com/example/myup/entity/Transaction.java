package com.example.myup.entity;

import com.example.myup.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tbl-transaction")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends AbstractEntity {

    private String trxId;
    private Date date;
    private Double amount;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "account id")
    private Account account;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
}
