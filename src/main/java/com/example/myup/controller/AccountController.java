package com.example.myup.controller;

import com.example.myup.dto.AccountDto;
import com.example.myup.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
@EnableCaching
@Transactional(readOnly = true)
public class AccountController {

    private AccountService accountService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> create(@RequestBody AccountDto dto) {
        accountService.save(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Cacheable(cacheNames = "CONTROLLER CACHE",key = "#id")
    public ResponseEntity<AccountDto> getById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getById(id);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Transactional
    public void update(@PathVariable Long id, @RequestBody AccountDto dto) {
        accountService.update(id, dto);
    }

    @DeleteMapping("{id}")
    @CacheEvict(cacheNames ="CONTROLLER CACHE",key = "#id" )
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            accountService.deleteById(id);
            return ResponseEntity.ok("Account with id: " + id + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Acount with id: " + id + " not deleted. error: " + e.getMessage());
        }
    }


}
