public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
        System.out.printf("Withdrew $%.2f. Remaining balance: $%.2f%n", amount, balance);
    }

    public double getBalance() {
        return balance;
    }
}