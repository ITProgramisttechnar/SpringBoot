package org.example.springboot.service;

import lombok.RequiredArgsConstructor;
import org.example.springboot.repository.UpdateUserRequest;
import org.example.springboot.repository.User;
import org.example.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User create(User user){
        return userRepository.save(user);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
@Transactional
public User updateUser(Long id, UpdateUserRequest request) {
    Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()) {
            throw new IllegalStateException("user с таким id: " + id + " не существует");
        }
    User user = optionalUser.get();

    if (request.getName() != null) {
        user.setName(request.getName());
    }
    if (request.getLastname() != null) {
        user.setLastname(request.getLastname());
    }
    if (request.getAge() != null) {
        user.setAge(request.getAge());
    }
    return userRepository.save(user);
    }
}
