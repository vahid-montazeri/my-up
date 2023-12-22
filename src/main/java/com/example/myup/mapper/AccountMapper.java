package com.example.myup.mapper;

import com.example.myup.dto.AccountDto;
import com.example.myup.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountDto> {


}
