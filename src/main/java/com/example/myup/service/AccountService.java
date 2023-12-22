package com.example.myup.service;

import com.example.myup.dto.AccountDto;

import java.util.List;

public interface AccountService {

    void save(AccountDto accountDto);

    AccountDto getById(String id);

    List<AccountDto> getAll();

    void update(String id, AccountDto dto);

    void deleteById(String id);

    void deleteAll();
}