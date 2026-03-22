package org.example.CourseProjectBaseJave;

import org.example.CourseProjectBaseJave.exception.TransferException;
import org.example.CourseProjectBaseJave.model.Transaction;
import org.example.CourseProjectBaseJave.service.ParserService;
import org.example.CourseProjectBaseJave.service.ReportService;
import org.example.CourseProjectBaseJave.service.TransferService;
import org.example.CourseProjectBaseJave.util.FileUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppMain {

    private static final String ACCOUNTS_FILE = "accounts.txt";
    private static final String INPUT_DIR = "input";
    private static final String ARCHIVE_DIR = "archive";

    private static final ReportService reportService = new ReportService();
    private static final ParserService parserService = new ParserService();

    private static Map<String, Long> accounts;
    private static TransferService transferService;

    public static void main(String[] args) {

        if (!loadAccounts()) {
            System.out.println("Где-то ошибка в загрузке...");
        }

        Scanner scanner = new Scanner(System.in);

        boolean run = true;

        while (run) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    processInputFiles();
                    break;
                case "2":
                    reportService.showAllReports();
                    break;
                case "0":
                    run = false;
                    System.out.println("Выход из программы");
                    break;
                default:
                    System.out.println("Опять за старое?");
            }
        }
        scanner.close();
    }

    private static boolean loadAccounts() {
        try {
            accounts = FileUtils.readAccountsFile(ACCOUNTS_FILE);
            transferService = new TransferService(accounts);

            if (accounts.isEmpty()) {
                System.out.println("Брат, файл пуст");
                return false;
            }

            System.out.println("Счетов загружено: " + accounts.size());
            System.out.println(accounts);
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка в файле " + e.getMessage());
            return false;
        }
    }

    private static void printMenu() {
        System.out.println("\n--- ЧТО_КУДА ---");
        System.out.println("1. Парсинг файлов из папки 'input'");
        System.out.println("2. История переводов");
       System.out.println("0. Выход");
        System.out.print("Чаво желаем?");
    }

    private static void processInputFiles() {
        try {
            List<Path> files = FileUtils.getTxtFiles(INPUT_DIR);

            if (files.isEmpty()) {
                System.out.println("Упс, в 'input' нет txt файлов, надо зайти в test_data_transfer и скопировать оттуда" +
                    "файлы в 'input' с вариантами переводов");
                return;
            }

            System.out.println("Найдено файлов: " + files.size());

            int success = 0;
            int failed = 0;

            for (Path file : files) {
                try {
                    Transaction rawTransaction = parserService.parseFile(file);
                    Transaction result = transferService.executeTransfer(rawTransaction);
                    reportService.logTransaction(result);
                    FileUtils.moveFile(file, ARCHIVE_DIR);

                    if (result.isSuccess()) {
                        success++;
                        System.out.println("успешно");
                    } else {
                        failed++;
                        System.out.println("ошибка: " + result.getErrorMessage());
                    }

                } catch (TransferException e) {
                    failed++;
                    System.out.println("Ошибка парсинга: " + e.getMessage());
                    Transaction errorTransaction = new Transaction(
                        "unknown", "unknown", 0, "Ошибка парсинга: " + e.getMessage());
                    reportService.logTransaction(errorTransaction);
                    FileUtils.moveFile(file, ARCHIVE_DIR);

                } catch (IOException e) {
                    failed++;
                    System.out.println("ошибка: " + e.getMessage());
                }
            }

            FileUtils.saveAccountsFile(ACCOUNTS_FILE, accounts);

            System.out.println("\n--- Имеем по итогу ---");
            System.out.println("Успешных переводов: " + success);
            System.out.println("Ошибок: " + failed);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении папки input: " + e.getMessage());
        }
    }
}
