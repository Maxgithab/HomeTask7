package org.example.CourseProjectBaseJave.model;

public class Transaction {
    private final String fromAccount;
    private final String toAccount;
    private final long amount;
    private final boolean success;
    private final String errorMessage;

    public Transaction(String fromAccount, String toAccount, long amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.success = true;
        this.errorMessage = null;
    }

    public Transaction(String fromAccount, String toAccount, long amount, String errorMessage) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.success = false;
        this.errorMessage = errorMessage;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public long getAmount() {
        return amount;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {

        String timestamp = java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        if (errorMessage == null) {
            return "Время " + timestamp + " Перевод {" +
                " с " + fromAccount + '\'' +
                " на " + toAccount + '\'' +
                " в количестве=" + amount;
        } else {
            return "Время " + timestamp + " Перевод {" +
                " с " + fromAccount + '\'' +
                " на " + toAccount + '\'' +
                " в количестве=" + amount +
                ", Не выполнено из-за: " + errorMessage + '\'' +
                '}';
        }
    }
}
