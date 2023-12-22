package com.example.myup.controller;

import com.example.myup.dto.CardDto;
import com.example.myup.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
@AllArgsConstructor
public class CardController {

    private CardService cardService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CardDto dto) {
        cardService.save(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> getById(@PathVariable String id) {
        CardDto dto = cardService.getById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody CardDto dto) {
        cardService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        try {
            cardService.deleteById(id);
            return ResponseEntity.ok("Card with id: " + id + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Card with id: " + id + " not deleted. error: " + e.getMessage());
        }
    }


}
