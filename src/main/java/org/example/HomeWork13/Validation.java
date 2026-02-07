package org.example.HomeWork13;

public class Validation {

    public static boolean validate(String login, String password, String passwordConfirm) {
        try {
            checkLogin(login);
            checkPassword(password, passwordConfirm);
            System.out.println("------Валидация прошла------");
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Получена ошибка: " + e.getMessage());
            return false;
        }
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (login == null || login.isEmpty()) {
            throw new WrongLoginException("а Логин-то пустой");
        }
        if (login.length() >= 20) {
            throw new WrongLoginException("Логин больше 20 символов");
        }
        if (login.contains(" ")) {
            throw new WrongLoginException("Логин не должен содержать пробелы");
        }
    }


    private static void checkPassword(String password, String passwordConfirm) throws WrongPasswordException {

        if (password == null || passwordConfirm == null || password.isEmpty() || passwordConfirm.isEmpty()) {
            throw new WrongPasswordException("Зачем пустой, брат?..");
        }

        if (password.length() >= 20) {
            throw new WrongPasswordException("Пароль больше 20 символов");
        }
        if (password.contains(" ")) {
            throw new WrongPasswordException("Пароль не должен содержать пробелы");
        }
        boolean hasNumbers = password.matches(".*\\d.*");
        if (!hasNumbers) {
            throw new WrongPasswordException("Пароль должен содержать хотя бы одну цифру");
        }
        if (!password.equals(passwordConfirm)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
    }
}