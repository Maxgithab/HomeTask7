package org.example.HomeWork13;

public class WrongLoginException extends Exception {

    public WrongLoginException (String message) {
        super(message);
    }

    private static void checkLogin(String login) throws WrongPasswordException {
        if (login != null) {
            if (login.length() >= 20) {
                throw new WrongPasswordException("Логин больше 20 символов");
            }
            if (login.contains(" ")) {
                throw new WrongPasswordException("Логин не должен содержать пробелы");
            }
        }
    }
}
