package org.example.HomeWork13;

public class WrongPasswordException extends Exception {

    public WrongPasswordException(String message) {
        super(message);
    }

    private static void checkPassword(String password, String passwordConfirm) throws WrongPasswordException {
        if (password != null || passwordConfirm != null) {
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
}