package com.example.myup.service;

import com.example.myup.dto.AccountDto;
import com.example.myup.entity.Account;
import com.example.myup.mapper.AccountMapper;
import com.example.myup.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public void save(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        accountRepository.save(account);
    }

    @Override
    public AccountDto getById(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with id " + id + " not found"));
        return accountMapper.toDto(account);
    }

    @Override
    public List<AccountDto> getAll() {
        List<Account> allAccounts = accountRepository.findAll();
        return accountMapper.toDtos(allAccounts);
    }

    @Override
    public void update(String id, AccountDto accountDto) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
        accountMapper.update(existingAccount, accountDto);
        accountRepository.save(existingAccount);
    }

    @Override
    public void deleteById(String id) {
        try {
            accountRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        accountRepository.deleteAll();
    }
}

