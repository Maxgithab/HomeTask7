package org.example.CourseProjectBaseJave.model;

public class Account {
    private String accountNumber;
    private long balance;

    public Account(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
            "accountNumber='" + accountNumber + '\'' +
            ", balance=" + balance +
            '}';
    }
}