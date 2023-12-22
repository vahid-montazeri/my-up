package com.example.myup.service;

import com.example.myup.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    void save(TransactionDto transactionDto);

    TransactionDto getById(String id);

    List<TransactionDto> getAll();

    void update(String id, TransactionDto transactionDto);

    void deleteById(String id);


}
