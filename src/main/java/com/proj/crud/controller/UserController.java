package com.proj.crud.controller;

import org.springframework.web.bind.annotation.RestController;

import com.proj.crud.model.User;
import com.proj.crud.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;



@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("user")
    public List<User> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "9") int size, @RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "true") Boolean isAscn) {
        Sort sort = Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return userService.getAllUsers(pageable).getContent();
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping("user")
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return userService.getUser(user.getId());
    }

    @PutMapping("user/{id}")
    public User updatUser(@PathVariable int id, @RequestBody User user) {
        userService.updateUser(id, user);
        return userService.getUser(id);
    }

    @PatchMapping("user/{id}")
    public User updatePartialUser(@PathVariable int id, @RequestBody User updates) {
        userService.updatePartialUser(id, updates);
        return userService.getUser(id);
    }

    @DeleteMapping("user/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "Deletion Successful";
    }

    @GetMapping("user/filter")
    public List<User> getMethodName(@RequestParam User.Status status) {
        return userService.getUserByStatus(status);
    }
    
    
}
