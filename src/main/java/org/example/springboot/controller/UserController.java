package org.example.springboot.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.catalina.util.Introspection;
import org.example.springboot.repository.User;
import org.example.springboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path ="api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

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
    @PutMapping(path = "{id}")
    public void update(@PathVariable Long id,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String lastname,
                       @RequestParam(required = false)Integer age){
        userService.update(id, name, lastname, age);
    }
}

