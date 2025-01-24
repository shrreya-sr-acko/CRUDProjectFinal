package com.proj.crud.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.crud.exception.ResourceNotFoundException;
import com.proj.crud.model.Account;
import com.proj.crud.repository.AccountRepo;
import com.proj.crud.repository.UserRepo;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    public Account addNewAccount(Account acc) {
        acc.setCreatedAt(LocalDateTime.now());
        acc.setUpdatedAt(LocalDateTime.now());
        if(userRepo.findById(acc.getUserId()) == null) throw new ResourceNotFoundException("User not found with the id: "+ acc.getUserId());
        return accountRepo.save(acc);
    }

    public Account getAccountById(String id) {
        Account acc = accountRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found with the id: "+ id));
        return acc;
    }

    public Account updateAccount(String id, Account updatedAcc) {
        Account acc = accountRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found with the id: "+ id));
        acc.setUsername(updatedAcc.getUsername());
        acc.setPassword(updatedAcc.getPassword());
        acc.setUserId(updatedAcc.getUserId());
        acc.setUpdatedAt(LocalDateTime.now());
        if(userRepo.findById(acc.getUserId()) == null) throw new ResourceNotFoundException("User not found with the id: "+ acc.getUserId());
        return accountRepo.save(acc);
        
    }

    public Account updatePartialAccount(String id, Account updatedAcc) {
        Account acc = accountRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found with the id: "+ id));
        if(updatedAcc.getUsername() != null) acc.setUsername(updatedAcc.getUsername());
        if(updatedAcc.getPassword() != null) acc.setPassword(updatedAcc.getPassword());
        if(updatedAcc.getUserId() != 0 ) acc.setUserId(updatedAcc.getUserId());
        acc.setUpdatedAt(LocalDateTime.now());
        if(userRepo.findById(acc.getUserId()) == null) throw new ResourceNotFoundException("User not found with the id: "+ acc.getUserId());
        return accountRepo.save(acc);
    }

    public void deleteAccount(String id) {
        accountRepo.deleteById(id);
    }
}
