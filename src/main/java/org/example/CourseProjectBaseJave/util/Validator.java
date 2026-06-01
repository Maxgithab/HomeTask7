package org.example.CourseProjectBaseJave.util;

import org.example.CourseProjectBaseJave.exception.TransferException;

import java.util.Map;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern ACCOUNT_FORMAT = Pattern.compile("^\\d{5}-\\d{5}$");

    public static boolean isValidAccountFormat(String accountNumber) {
        return accountNumber != null && ACCOUNT_FORMAT.matcher(accountNumber).matches();
    }

    public static boolean isValidAmount(long amount) {
        return amount > 0;
    }

    public static boolean accountExists(String accountNumber, Map<String, Long> accounts) {
        return accounts.containsKey(accountNumber);
    }

    public static boolean hasEnoughFunds(String accountNumber, long amount, Map<String, Long> accounts) {
        Long balance = accounts.get(accountNumber);
        return balance != null && balance >= amount;
    }

    public static void validateTransaction(String fromAccount, String toAccount, long amount, Map<String, Long> accounts) throws TransferException {

        if (!isValidAccountFormat(fromAccount)) {
            throw new TransferException("Ошибка формата счёта списания: " + fromAccount);
        }

        if (!isValidAccountFormat(toAccount)) {
            throw new TransferException("Ошибка формата счёта зачисления: " + toAccount);
        }

        if (!isValidAmount(amount)) {
            throw new TransferException("Тут сумма отрицательная: " + amount);
        }

        if (!accountExists(fromAccount, accounts)) {
            throw new TransferException("Счёта списания не существует: " + fromAccount);
        }

        if (!accountExists(toAccount, accounts)) {
            throw new TransferException("Счёта зачисления не существует: " + toAccount);
        }

        if (!hasEnoughFunds(fromAccount, amount, accounts)) {
            long balance = accounts.get(fromAccount);
            throw new TransferException("На счёте " + fromAccount + " сейчас: " + balance + ", а надо: " + amount);
        }

    }
}
