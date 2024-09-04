package com.bankmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Transaction deposit(Long accountId, Transaction transaction) {
        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new RuntimeException("Account not found"));
        transaction.setType("deposit");
        account.setBalance(account.getBalance() + transaction.getAmount());
        accountRepository.save(account);
        return transactionRepository.save(transaction);
    }

    public Transaction withdraw(Long accountId, Transaction transaction) {
        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < transaction.getAmount()) {
            throw new RuntimeException("Insufficient funds");
        }
        transaction.setType("withdrawal");
        account.setBalance(account.getBalance() - transaction.getAmount());
        accountRepository.save(account);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByAccount(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}