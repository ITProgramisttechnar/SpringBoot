package org.example.springboot.service;

import org.example.springboot.repository.User;
import org.example.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User create(User user){
        return userRepository.save(user);
    }
    public void delete(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new IllegalStateException("user с таким id: " + id + " не существует");
        }
        userRepository.deleteById(id);
    }
    public void update(Long id, String name, String lastname, Integer age){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new IllegalStateException("user с таким id: " + id + " не существует");
        }
        User user = optionalUser.get();
        user.setName(name);
        user.setLastname(lastname);
        user.setAge(age);
        userRepository.save(user);
    }
}
