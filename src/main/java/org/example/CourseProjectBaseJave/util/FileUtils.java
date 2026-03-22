package org.example.CourseProjectBaseJave.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileUtils {

    public static List<Path> getTxtFiles(String directoryPath) throws IOException {
        Path dir = Paths.get(directoryPath);

        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
            return Collections.emptyList();
        }

        return Files.list(dir)
            .filter(path -> path.toString().toLowerCase().endsWith(".txt"))
            .collect(Collectors.toList());
    }

    public static List<String> readAllLines(Path filePath) throws IOException {
        return Files.readAllLines(filePath);
    }

    public static void writeLines(Path filePath, List<String> lines) throws IOException {
        Files.write(filePath, lines);
    }

    public static void appendLine(Path filePath, String line) throws IOException {

        Path parent = filePath.getParent();
        if (parent != null && !Files.exists(parent)) {
            Files.createDirectories(parent);
        }

        Files.write(filePath, Collections.singletonList(line),
            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public static void moveFile(Path sourcePath, String targetDirectory) throws IOException {
        Path targetDir = Paths.get(targetDirectory);

        if (!Files.exists(targetDir)) {
            Files.createDirectories(targetDir);
        }

        Path targetPath = targetDir.resolve(sourcePath.getFileName());
        Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }

    public static boolean fileExists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }

    public static Map<String, Long> readAccountsFile(String filePath) throws IOException {
        Map<String, Long> accounts = new HashMap<>();

        if (!fileExists(filePath)) {
            return accounts;
        }

        List<String> lines = readAllLines(Paths.get(filePath));

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#") || line.startsWith("//")) {
                continue;
            }

            String[] parts = line.split(":");
            if (parts.length == 2) {
                try {
                    String accountNumber = parts[0].trim();
                    long balance = Long.parseLong(parts[1].trim());
                    accounts.put(accountNumber, balance);
                } catch (NumberFormatException e) {
                    System.out.println("Что-то не так со строкой: " + line);
                }
            }
        }
        return accounts;
    }

    public static void saveAccountsFile(String filePath, Map<String, Long> accounts) throws IOException {
        List<String> lines = new ArrayList<>();

        for (Map.Entry<String,Long> entry : accounts.entrySet()) {
            lines.add(entry.getKey() + ":" + entry.getValue());
        }
        writeLines(Paths.get(filePath), lines);
    }
}
