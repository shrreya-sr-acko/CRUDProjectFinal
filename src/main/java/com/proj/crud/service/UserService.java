package com.proj.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.proj.crud.exception.ResourceNotFoundException;
import com.proj.crud.model.User;
import com.proj.crud.repository.UserRepo;
import org.springframework.data.domain.Pageable;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    public Page<User> getAllUsers(Pageable pageable){
        return userRepo.findAll(pageable);
    }

    public User getUser(int id) {
        User user = userRepo.findById(id);
        if(user == null) throw new ResourceNotFoundException("User not found with the id: "+ id);
        return user;
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void updateUser(int id, User user) {
        User updatedUser = userRepo.findById(id);
        if(updatedUser == null) throw new ResourceNotFoundException("User not found with the id: "+ id);
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setAge(user.getAge());
        updatedUser.setStatus(user.getStatus());
        userRepo.save(updatedUser);
    }

    public void updatePartialUser(int id, User user) {
        User updatedUser = userRepo.findById(id);
        if(user.getName() != null) updatedUser.setName(user.getName());
        if(user.getEmail() != null) updatedUser.setEmail(user.getEmail());
        if(user.getAge() != 0) updatedUser.setAge(user.getAge());
        if(user.getStatus() != null) updatedUser.setStatus(user.getStatus());
        userRepo.save(updatedUser);
    }

    public void deleteUser(int id) {
        User user = userRepo.findById(id);
        if(user == null) throw new ResourceNotFoundException("User not found with the id: "+ id);
        userRepo.deleteById(id);
    }

    public List<User> getUserByStatus(User.Status status) {
        return userRepo.findByStatus(status);
    }
}
