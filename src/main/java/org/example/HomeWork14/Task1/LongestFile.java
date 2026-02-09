package org.example.HomeWork14.Task1;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LongestFile {
    public static void main(String[] args) {

        try {
            InputStream inputFile = LongestFile.class.getClassLoader()
                .getResourceAsStream("Romeo_and_Juliet.txt");

            if (inputFile == null) {
                System.out.println("Файла в директории нет");
                return;
            }

            String text = new String(inputFile.readAllBytes());
            inputFile.close();

            String[] words = text.split("[^a-zA-Z']+");

            String longestWord = "";

            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }

            System.out.println("Самое длинное слово: " + longestWord + "\nДлина: " + longestWord.length());

            Path outputPath = Paths.get("longest.txt");
            Files.writeString(outputPath, longestWord);

            System.out.println("Путь к сохраненному файлу : " + outputPath.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Упс " + e.getMessage());
        }
    }
}

