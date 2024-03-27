package com.example.shop.rest;

import com.example.shop.entity.User;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.add(user));
    }

    @GetMapping("/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable String login) {
        return ResponseEntity.ok(userService.getByLogin(login));
    }

    @GetMapping("/firstAndLastName")
    public ResponseEntity<List<User>> getUsersByNameAndSurnameMask(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return ResponseEntity.ok(userService.getByFirstNameAndLastName(firstName, lastName));
    }
}
