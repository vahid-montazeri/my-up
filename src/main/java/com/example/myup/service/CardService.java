package com.example.myup.service;

import com.example.myup.dto.CardDto;

import java.util.List;

public interface CardService {


    void save(CardDto cardDto);

    CardDto getById(String id);

    List<CardDto> getAll();


    void update(String id, CardDto cardDto);

    void deleteById(String id);
}