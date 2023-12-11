package com.example.myup.service;

import com.example.myup.dto.TransactionDto;

public interface TransactionService {

    void save(TransactionDto transactionDto);

    TransactionDto getById(Long id);

    void update(Long id, TransactionDto transactionDto);

    void deleteById(Long id);


}
