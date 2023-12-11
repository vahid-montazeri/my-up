package com.example.myup.dto;

import com.example.myup.entity.Card;
import com.example.myup.entity.Transaction;
import com.example.myup.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccountDto extends AbstractDto {
    private Long accountNumber;
    private Double balance;
//    private User user;
//    private Card card;
//    private List<Transaction> transactions;
}
