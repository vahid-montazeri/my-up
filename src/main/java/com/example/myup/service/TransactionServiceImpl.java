package com.example.myup.service;

import com.example.myup.dto.TransactionDto;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public void save(TransactionDto transactionDto) {

    }

    @Override
    public TransactionDto getById(Long id) {
        return null;
    }

    @Override
    public void update(Long id, TransactionDto transactionDto) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
