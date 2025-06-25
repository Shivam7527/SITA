package com.sshukla7527.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshukla7527.demo.entity.User;
import com.sshukla7527.demo.repository.UserNotFoundException;
import com.sshukla7527.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired private UserRepository repository;

    public User create(User user) { return repository.save(user); }
    public User getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
    public User update(Long id, User user) {
        User existing = getById(id);
        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());
        existing.setEmail(user.getEmail());
        return repository.save(existing);
    }
    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
