package com.proj.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.proj.crud.model.Account;

@Repository
public interface AccountRepo extends MongoRepository<Account, String> {
    
} 
