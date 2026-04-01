public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(double shortfall) {
        super(String.format("Insufficient funds. You are short by $%.2f", shortfall));
    }
}