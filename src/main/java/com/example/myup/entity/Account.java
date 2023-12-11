package com.example.myup.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name = "tbl-account")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends AbstractEntity {
    private Long accountNumber;
    @Min(value = 100 , message = "account.balance")
    private Double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user id")
    private User user;
    @OneToMany(mappedBy = "account",targetEntity = Transaction.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private  List<Transaction> transaction;
//    private Card card;
//    private List<Transaction> transactions;
}
