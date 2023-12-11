package com.example.myup.mapper;

import com.example.myup.dto.TransactionDto;
import com.example.myup.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends BaseMapper<Transaction, TransactionDto> {


}
