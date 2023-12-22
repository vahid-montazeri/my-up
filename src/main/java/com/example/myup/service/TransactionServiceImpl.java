package com.example.myup.service;

import com.example.myup.dto.TransactionDto;
import com.example.myup.entity.Transaction;
import com.example.myup.mapper.TransactionMapper;
import com.example.myup.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public void save(TransactionDto transactionDto) {
        Transaction transaction = transactionMapper.toEntity(transactionDto);
        transactionRepository.save(transaction);
    }

    @Override
    public TransactionDto getById(String id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction with id " + id + " not found"));
        return transactionMapper.toDto(transaction);
    }

    @Override
    public List<TransactionDto> getAll() {
        List<Transaction> allTransactions = transactionRepository.findAll();
        return transactionMapper.toDtos(allTransactions);
    }

    @Override
    public void update(String id, TransactionDto transactionDto) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction with id " + id + " not found"));
        transactionMapper.update(existingTransaction, transactionDto);
        transactionRepository.save(existingTransaction);
    }

    @Override
    public void deleteById(String id) {
        try {
            transactionRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Transaction with id " + e.getMessage());
        }
    }
}
