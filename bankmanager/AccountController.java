package com.bankmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/client/{clientId}")
    public List<Account> getAccountsByClient(@PathVariable Long clientId) {
        return accountService.getAccountsByClient(clientId);
    }

    @PostMapping("/client/{clientId}")
    public Account createAccount(@PathVariable Long clientId, @RequestBody Account account) {
        return accountService.createAccount(clientId, account);
    }
}