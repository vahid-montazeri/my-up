package com.example.myup.mapper;

import com.example.myup.dto.CardDto;
import com.example.myup.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends BaseMapper<Card, CardDto> {


}
