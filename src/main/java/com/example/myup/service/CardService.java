package com.example.myup.service;

import com.example.myup.dto.CardDto;

public interface CardService {


    void save(CardDto cardDto);

    CardDto getById(Long id);

    void update(Long id, CardDto cardDto);

    void deleteById(Long id);
}