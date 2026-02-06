package org.example.springboot.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.util.Introspection;
import org.example.springboot.repository.UpdateUserRequest;
import org.example.springboot.repository.User;
import org.example.springboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path ="api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
    @PutMapping("/{id}")
public ResponseEntity<User> updateUser(
        @PathVariable Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String lastname,
        @RequestParam(required = false) Integer age) {
    UpdateUserRequest request = new UpdateUserRequest(name, lastname, age);
    User updatedUser = userService.updateUser(id, request);
    return ResponseEntity.ok(updatedUser);
    }
}

