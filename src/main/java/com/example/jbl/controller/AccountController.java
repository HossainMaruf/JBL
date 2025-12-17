package com.example.jbl.controller;

import com.example.jbl.model.Account;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private List<Account> accounts = new ArrayList<>();

    // Constructor with some default accounts
    public AccountController() {
        accounts.add(new Account(1L, "Alice", 5000));
        accounts.add(new Account(2L, "Bob", 3000));
    }

    // GET all accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return accounts;
    }

    // GET account by id
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accounts.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // POST create new account
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        accounts.add(account);
        return account;
    }

    // PUT update account balance
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount) {
        for (Account a : accounts) {
            if (a.getId().equals(id)) {
                a.setName(updatedAccount.getName());
                a.setBalance(updatedAccount.getBalance());
                return a;
            }
        }
        return null;
    }

    // DELETE account
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accounts.removeIf(a -> a.getId().equals(id));
        return "Deleted account with id " + id;
    }
}
