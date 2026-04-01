import java.util.Scanner;

class SafeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter first number (or 'exit'): ");
                String val1 = input.nextLine();
                if (val1.equalsIgnoreCase("exit")) break;

                System.out.print("Enter second number: ");
                String val2 = input.nextLine();
                if (val2.equalsIgnoreCase("exit")) break;

                int a = Integer.parseInt(val1);
                int b = Integer.parseInt(val2);

                System.out.println("Result: " + a + " / " + b + " = " + (a / b));
            }
            catch (ArithmeticException e) {
                System.out.println("Error: Cannot divide by zero. Try again.");
            }
            catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid integers only.");
            }
        }
        System.out.println("Goodbye!");
    }
}