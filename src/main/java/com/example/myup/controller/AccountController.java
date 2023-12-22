package com.example.myup.controller;

import com.example.myup.dto.AccountDto;
import com.example.myup.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody AccountDto dto) {
        accountService.save(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Cacheable(cacheNames = "CONTROLLER CACHE", key = "#id")
    public ResponseEntity<AccountDto> getById(@PathVariable String id) {
        AccountDto accountDto = accountService.getById(id);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody AccountDto dto) {
        accountService.update(id, dto);
    }

    @DeleteMapping("{id}")
    @CacheEvict(cacheNames = "CONTROLLER CACHE", key = "#id")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        try {
            accountService.deleteById(id);
            return ResponseEntity.ok("Account with id: " + id + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Acount with id: " + id + " not deleted. error: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAll() {
        List<AccountDto> accountDtoList = accountService.getAll();
        return new ResponseEntity<>(accountDtoList, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        accountService.deleteAll();
        return ResponseEntity.ok().body(null);
    }


}
