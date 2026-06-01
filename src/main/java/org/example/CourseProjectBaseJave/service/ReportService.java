package org.example.CourseProjectBaseJave.service;

import org.example.CourseProjectBaseJave.model.Transaction;
import org.example.CourseProjectBaseJave.util.FileUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReportService {

    private static final String  REPORT_FILE = "report.txt";

    public void logTransaction (Transaction transaction) {
        try {
            FileUtils.appendLine(Paths.get(REPORT_FILE), transaction.toString());
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void showAllReports() {
        try {
            Path reportPath = Paths.get(REPORT_FILE);

            if (!FileUtils.fileExists(REPORT_FILE)) {
                System.out.println("Файл отчёта пока пуст.");
                return;
            }

            List<String> lines = FileUtils.readAllLines(reportPath);

            if (lines.isEmpty()) {
                System.out.println("Отчетный файл пока пуст");
                return;
            }

            for (String line: lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
