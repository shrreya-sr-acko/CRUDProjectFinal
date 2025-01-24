package com.proj.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proj.crud.model.Account;
import com.proj.crud.service.AccountService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("account")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("account/{id}")
    public Account getAccountById(@PathVariable String id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("account")
    public Account addNewAccount(@RequestBody Account acc) {
        return accountService.addNewAccount(acc);
    }

    @PutMapping("account/{id}")
    public Account updateAccount(@PathVariable String id, @RequestBody Account acc) {
        return accountService.updateAccount(id,acc);
    }

    @PatchMapping("account/{id}")
    public Account partiallyUpdateAccount(@PathVariable String id, @RequestBody Account acc) {
        return accountService.updatePartialAccount(id,acc);
    }

    @DeleteMapping("account/{id}")
    public String updateAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        return "Deletion Successful";
    }

    
}
