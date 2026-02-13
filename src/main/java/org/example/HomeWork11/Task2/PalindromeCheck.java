package org.example.HomeWork11.Task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PalindromeCheck {

    public void checkPalindrome() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите строку: ");
            String palindromeInput = scanner.nextLine().trim();

            if (palindromeInput.isEmpty()) {
                System.out.println("Зачем пустой, брат?!");
                return;
            }
            System.out.print("Какое слово будем проверять?");
            int wordNumber;
            try {
                wordNumber = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Петька, не шали! Нужно ввести число!");
            }
            if (wordNumber < 1) {
                throw new IllegalArgumentException("А проверять мы будем отрицательное слово, да?");
            }

            String[] words = palindromeInput.split("\\s+");
            if (wordNumber > words.length) {
                throw new IllegalArgumentException(
                    String.format("Серьезно? В строке так-то %d слов, а ввел %d!",
                        words.length, wordNumber)
                );
            }

            checkWordPalindrome(palindromeInput, wordNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Миша, давай по-новой!");
        } finally {
            scanner.close();
        }
    }

    public void checkWordPalindrome(String text, int wordNumber) {
        String[] words = text.split("\\s+");
        String target = words[wordNumber - 1];

        String cleaningWord = target.replaceAll("[^a-zA-Zа-яА-Я0-9]", "").toLowerCase();

        System.out.println("Анализ слова " + target);

        boolean result1 = isPalindromeString(cleaningWord);
        boolean result2 = isPalindromeStringBuilder(cleaningWord);
        boolean result3 = isPalindromeStringBuffer(cleaningWord);

        if (result1 && result2 && result3) {
            System.out.println("\nСлово \"" + target + "\" - палиндром");
        } else {
            System.out.println("\nСлово \"" + target + "\" - не палиндром");
        }
    }

    private boolean isPalindromeString(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindromeStringBuilder(String word) {
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();
        return word.equals(reversed);
    }

    private boolean isPalindromeStringBuffer(String word) {
        StringBuffer buffer = new StringBuffer(word);
        String reversed = buffer.reverse().toString();
        return word.equals(reversed);
    }

}