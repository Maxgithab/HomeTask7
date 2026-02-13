package org.example.HomeWork14.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ValidationDoc {
    private final String inputFile;
    private final List<String> validDocs;
    private final List<String> invalidDocs;

    public ValidationDoc(String inputFile) {
        this.inputFile = inputFile;
        this.validDocs = new ArrayList<>();
        this.invalidDocs = new ArrayList<>();
    }

    public void validate() throws IOException {
        Path path = Paths.get(inputFile);
        if (!Files.exists(path)) {
            throw new IOException("Упс, нет файла");
        }

        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            if (line.isEmpty()) continue;

            String checkErrors = validateDocument(line);
            if (checkErrors == null) {
                validDocs.add(line);
            } else {
                invalidDocs.add(line + " - " + checkErrors);
            }
        }
        saveResults();
    }


    private void saveResults() throws IOException {
        if (!validDocs.isEmpty()) {
            Files.write(Paths.get("valid_documents.txt"), validDocs);
        }

        if (!invalidDocs.isEmpty()) {
            Files.write(Paths.get("invalid_documents.txt"), invalidDocs);
        }
    }

private String validateDocument(String document) {
    if (document.length() != 15) {
        return "длина не 15 символов";
    }

    if (!document.startsWith("docnum") && !document.startsWith("contract")) {
        return "не начинается с docnum или contract";
    }

    if (!document.matches("[a-zA-Z0-9]+")) {
        return "недопустимые символы";
    }
    return null;
}

}
