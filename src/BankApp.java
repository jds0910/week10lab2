public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.00);
        System.out.printf("Balance: $%.2f%n", account.getBalance());

        double[] withdrawals = {200.00, 400.00, 100.00};

        for (double amount : withdrawals) {
            try {
                account.withdraw(amount);
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}