
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

abstract class Employee {
    String name, id;

    Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    abstract double calculateMonthlySalary() throws InvalidSalaryException;

    public double printPaySlip() {
        try {
            double salary = calculateMonthlySalary();
            System.out.printf("Xodim: %s (%s) | Oylik: $%.2f%n", name, id, salary);
            return salary;
        } catch (InvalidSalaryException e) {
            System.err.println("Xato (" + name + "): " + e.getMessage());
            return 0;
        }
    }
}

class FullTimeEmployee extends Employee {
    double annualSalary;

    FullTimeEmployee(String name, String id, double annualSalary) {
        super(name, id);
        this.annualSalary = annualSalary;
    }

    double calculateMonthlySalary() throws InvalidSalaryException {
        if (annualSalary <= 0) throw new InvalidSalaryException("Yillik maosh musbat bo'lishi shart!");
        return annualSalary / 12;
    }
}

class PartTimeEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    PartTimeEmployee(String name, String id, double rate, int hours) {
        super(name, id);
        this.hourlyRate = rate;
        this.hoursWorked = hours;
    }

    double calculateMonthlySalary() throws InvalidSalaryException {
        if (hourlyRate <= 0 || hoursWorked < 0) throw new InvalidSalaryException("Soatbay stavka yoki ish vaqti noto'g'ri!");
        return hourlyRate * hoursWorked;
    }
}

class CommissionEmployee extends Employee {
    double baseSalary, salesAmount, commissionRate;

    CommissionEmployee(String name, String id, double base, double sales, double rate) {
        super(name, id);
        this.baseSalary = base;
        this.salesAmount = sales;
        this.commissionRate = rate;
    }

    double calculateMonthlySalary() throws InvalidSalaryException {
        if (commissionRate < 0 || commissionRate > 1) throw new InvalidSalaryException("Commission rate 0 va 1 oralig'ida bo'lsin!");
        return baseSalary + (salesAmount * commissionRate);
    }
}

public class PayrollDemo {
    public static void main(String[] args) {
        Employee[] staff = {
                new FullTimeEmployee("Ali", "FT01", 60000),
                new PartTimeEmployee("Vali", "PT02", 20, 80),
                new CommissionEmployee("Guli", "CE03", 2000, 5000, 0.1),
                new FullTimeEmployee("Xato_Xodim", "ERR", -100) // Exception throw qiladi
        };

        for (Employee e : staff) {
            e.printPaySlip();
        }
    }
}