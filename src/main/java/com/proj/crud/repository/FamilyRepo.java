package com.proj.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.crud.model.Family;
import com.proj.crud.model.User;

public interface FamilyRepo extends JpaRepository<Family, Integer> {

    List<Family> findByUser(User user);
    Family findById(int id);

}