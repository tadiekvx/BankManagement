package com.bankmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/account/{accountId}/deposit")
    public Transaction deposit(@PathVariable Long accountId, @RequestBody Transaction transaction) {
        return transactionService.deposit(accountId, transaction);
    }

    @PostMapping("/account/{accountId}/withdraw")
    public Transaction withdraw(@PathVariable Long accountId, @RequestBody Transaction transaction) {
        return transactionService.withdraw(accountId, transaction);
    }

    @GetMapping("/account/{accountId}")
    public List<Transaction> getTransactionsByAccount(@PathVariable Long accountId) {
        return transactionService.getTransactionsByAccount(accountId);
    }
}