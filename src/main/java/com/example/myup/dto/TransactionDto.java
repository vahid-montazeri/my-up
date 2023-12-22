package com.example.myup.dto;

import com.example.myup.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto extends AbstractDto {

    private String trxId;
    private Date date;
    private Double amount;
    private TransactionType transactionType;

}
