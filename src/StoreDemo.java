
interface Printable {
    void print();
}

interface Taxable {
    double TAX_RATE = 0.12;
    double calculateTax();
}

class Product implements Printable {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println("Mahsulot: " + name + " | Narxi: $" + price);
    }
}

class TaxableProduct extends Product implements Taxable {
    TaxableProduct(String name, double price) {
        super(name, price);
    }

    public double calculateTax() {
        return price * TAX_RATE;
    }

    @Override
    public void print() {
        double tax = calculateTax();
        System.out.println("Taxable Mahsulot: " + name + " | Price: $" + price +
                " | Tax: $" + tax + " | Total: $" + (price + tax));
    }
}

class DigitalProduct extends TaxableProduct {
    String downloadUrl;

    DigitalProduct(String name, double price, String url) {
        super(name, price);
        this.downloadUrl = url;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("---> Download linki: " + downloadUrl);
    }
}

public class StoreDemo {
    public static void main(String[] args) {
        Printable[] savatcha = {
                new Product("Non", 1.5),
                new TaxableProduct("Dazmol", 50.0),
                new DigitalProduct("Java Kursi", 100.0, "https://uzbek-dev.uz/java")
        };

        double jamiSoliq = 0;

        System.out.println("--- Do'konimizdagi mahsulotlar ---");
        for (Printable p : savatcha) {
            p.print();

            if (p instanceof Taxable) {
                jamiSoliq += ((Taxable) p).calculateTax();
            }
            System.out.println();
        }

        System.out.println("---------------------------------");
        System.out.println("Jami yig'ilgan soliq (Total Tax): $" + jamiSoliq);
    }
}