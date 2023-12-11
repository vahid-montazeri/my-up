package com.example.myup.controller;

import com.example.myup.dto.CardDto;
import com.example.myup.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
@AllArgsConstructor
@Transactional(readOnly = true)
public class CardController {
    private CardService cardService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> create(@RequestBody CardDto dto) {
        cardService.save(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> getById(@PathVariable Long id) {
        CardDto dto = cardService.getById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Transactional
    public void update(@PathVariable Long id, @RequestBody CardDto dto) {
        cardService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            cardService.deleteById(id);
            return ResponseEntity.ok("Card with id: " + id + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Card with id: " + id + " not deleted. error: " + e.getMessage());
        }
    }


}
