package com.example.myup.controller;

import com.example.myup.dto.UserDto;
import com.example.myup.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserController {

    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> create(@Validated @RequestBody UserDto userDto) {
        userService.save(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        UserDto dto = userService.getById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Transactional
    public void update(@PathVariable Long id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.ok("User with id: " + id + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("user with id: " + id + " not deleted. error: " + e.getMessage());
        }
    }


}
