package com.example.myup.controller;

import com.example.myup.dto.TransactionDto;
import com.example.myup.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {

    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TransactionDto transactionDto) {
        transactionService.save(transactionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getById(@PathVariable String id) {
        TransactionDto dto = transactionService.getById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody TransactionDto dto) {
        transactionService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        try {
            transactionService.deleteById(id);
            return ResponseEntity.ok("User with id: " + id + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("user with id: " + id + " not deleted. error: " + e.getMessage());
        }
    }


}
