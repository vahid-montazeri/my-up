package com.example.myup.service;

import com.example.myup.dto.AccountDto;

public interface AccountService {


    void save(AccountDto accountDto);

    AccountDto getById(Long id);

    void update(Long id, AccountDto dto);

    void deleteById(Long id);

}