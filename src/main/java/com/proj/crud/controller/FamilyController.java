package com.proj.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proj.crud.model.Family;
import com.proj.crud.service.FamilyService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class FamilyController {
    
    @Autowired
    private FamilyService famService;

    @GetMapping("user/{userId}/family")
    public List<Family> getAllFamilyMembers(@PathVariable int userId) {
        return famService.getAllFamilyMembers(userId);
    }
    
    @GetMapping("user/{userId}/family/{id}")
    public Family getFamilyMember(@PathVariable int id) {
        return famService.getFamilyMember(id);
    }

    @PostMapping("user/{userId}/family")
    public void addFamilyMember(@PathVariable int userId, @RequestBody Family fam) {
        famService.addFamilyMember(userId, fam);
    }

    @PutMapping("user/{userId}/family/{id}")
    public void updatFamilyMember(@PathVariable int id, @RequestBody Family family) {
        famService.updateFamilyMember(id, family);
    }

    @PatchMapping("user/{userId}/family/{id}")
    public void updatePartialFamilyMember(@PathVariable int id, @RequestBody Family updates) {
        famService.updatePartialFamilyMember(id, updates);
    }

    @DeleteMapping("user/{userId}/family/{id}")
    public String deleteFamilyMember(@PathVariable int id) {
        famService.deleteFamilyMember(id);
        return "Deletion Successful";
    }
    
}
