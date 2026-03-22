package org.example.CourseProjectBaseJave.service;

import org.example.CourseProjectBaseJave.exception.TransferException;
import org.example.CourseProjectBaseJave.model.Transaction;
import org.example.CourseProjectBaseJave.util.Validator;

import java.util.Map;

public class TransferService {

    private final Map<String, Long> accounts;

    public TransferService(Map<String, Long> accounts) {
        this.accounts = accounts;
    }

    public Transaction executeTransfer(Transaction transaction) {
        String fromAccount = transaction.getFromAccount();
        String toAccount = transaction.getToAccount();
        long amount = transaction.getAmount();

        try {
            Validator.validateTransaction(fromAccount, toAccount, amount, accounts);

            synchronized (accounts) {
                long fromBalance = accounts.get(fromAccount);
                long toBalance = accounts.get(toAccount);

                accounts.put(fromAccount, fromBalance - amount);
                accounts.put(toAccount, toBalance + amount);
            }

            return new Transaction(fromAccount, toAccount, amount);
        } catch (TransferException e) {
            return new Transaction(fromAccount, toAccount, amount, e.getMessage());
        }
    }

    public Long getBalance(String accountNumber) {
        return  accounts.get(accountNumber);
    }

    public Map<String, Long> getAllAccounts() {
        return Map.copyOf(accounts);
    }

    public boolean hasAccount(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public int getAccountsCount() {
        return accounts.size();
    }
}
