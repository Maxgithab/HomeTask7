package org.example.CourseProjectBaseJave.service;

import org.example.CourseProjectBaseJave.exception.TransferException;
import org.example.CourseProjectBaseJave.model.Transaction;
import org.example.CourseProjectBaseJave.util.Validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ParserService {

    public Transaction parseFile(Path filePath) throws TransferException, IOException {
        List<String> lines = Files.readAllLines(filePath);
        lines.removeIf(String::isEmpty);
        if (lines.size() < 3) {
            throw new TransferException("В файле меньше 3 строк");
        }

        String fromAccount = lines.get(0).trim();
        String toAccount = lines.get(1).trim();

        long amount;
        try {
            amount = Long.parseLong(lines.get(2).trim());
        } catch (NumberFormatException e) {
            throw new TransferException("Ошибка формата суммы: " + lines.get(2));
        }

        if (!Validator.isValidAccountFormat(fromAccount)) {
            throw new TransferException("Ошибка формата счёта списания: " + fromAccount);
        }

        if (!Validator.isValidAccountFormat(toAccount)) {
            throw new TransferException("Ошибка формата счёта зачисления: " + toAccount);
        }
        return new Transaction(fromAccount, toAccount, amount);
    }
}
