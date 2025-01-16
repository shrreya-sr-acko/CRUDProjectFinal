package com.proj.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.crud.exception.ResourceNotFoundException;
import com.proj.crud.model.Family;
import com.proj.crud.repository.FamilyRepo;
import com.proj.crud.repository.UserRepo;

@Service
public class FamilyService{
    @Autowired
    private FamilyRepo famRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Family> getAllFamilyMembers(int userId){
        if(userRepo.findById(userId) == null ) throw new ResourceNotFoundException("User not found with the id: "+ userId);
        return famRepo.findByUser(userRepo.findById(userId));
    }

    public Family getFamilyMember(int id) {
        Family fam = famRepo.findById(id);
        if(fam == null) throw new ResourceNotFoundException("Family Memmber not found with the id: "+ id);
        return fam;
    }

    public void addFamilyMember(int id, Family fam) {
        fam.setUser(userRepo.findById(id));
        famRepo.save(fam);
    }

    public void deleteFamilyMember(int id) {
        Family fam = famRepo.findById(id);
        if(fam == null) throw new ResourceNotFoundException("Family Memmber not found with the id: "+ id);
        famRepo.deleteById(id);
    }

    public void updateFamilyMember(int id, Family family) {
        Family fam = famRepo.findById(id);
        if(fam == null) throw new ResourceNotFoundException("Family Memmber not found with the id: "+ id);
        fam.setName(family.getName());
        fam.setRelation(family.getRelation());
        famRepo.save(fam);
    }

    public void updatePartialFamilyMember(int id, Family family) {
        Family fam = famRepo.findById(id);
        if(fam == null) throw new ResourceNotFoundException("Family Memmber not found with the id: "+ id);
        if(family.getName() != null) fam.setName(family.getName());
        if(family.getRelation() != null) fam.setRelation(family.getRelation());
        famRepo.save(fam);
    }
 
}