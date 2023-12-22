package com.example.myup.service;

import com.example.myup.dto.CardDto;
import com.example.myup.entity.Card;
import com.example.myup.mapper.CardMapper;
import com.example.myup.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {


    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    public void save(CardDto cardDto) {
        Card card = cardMapper.toEntity(cardDto);
        cardRepository.save(card);
    }

    @Override
    public CardDto getById(String id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Card with id " + id + " not found"));
        return cardMapper.toDto(card);
    }

    @Override
    public List<CardDto> getAll() {
        List<Card> allCards = cardRepository.findAll();
        return cardMapper.toDtos(allCards);
    }

    @Override
    public void update(String id, CardDto cardDto) {
        Card existingCard = cardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found"));
        cardMapper.update(existingCard, cardDto);
        cardRepository.save(existingCard);
    }

    @Override
    public void deleteById(String id) {
        try {
            cardRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, e.getMessage());
        }
    }
}

