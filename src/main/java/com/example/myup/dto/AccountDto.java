package com.example.myup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
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
