import java.util.*;

abstract class Shape {
    String color;
    Shape(String c) { color = c; }
    abstract double getArea();
    abstract double getPerimeter();
    void displayInfo() {
        System.out.println(getClass().getSimpleName() + " [Color: " + color + ", Area: " + String.format("%.2f", getArea()) + ", Perimeter: " + String.format("%.2f", getPerimeter()) + "]");
    }
}

class Circle extends Shape {
    double r;
    Circle(String c, double r) { super(c); this.r = r; }
    double getArea() { return Math.PI * r * r; }
    double getPerimeter() { return 2 * Math.PI * r; }
}

class Rectangle extends Shape {
    double w, h;
    Rectangle(String c, double w, double h) { super(c); this.w = w; this.h = h; }
    double getArea() { return w * h; }
    double getPerimeter() { return 2 * (w + h); }
}

class Triangle extends Shape {
    double a, b, c;
    Triangle(String col, double a, double b, double c) { super(col); this.a = a; this.b = b; this.c = c; }
    double getPerimeter() { return a + b + c; }
    double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] s = {
                new Circle("Red", 5), new Rectangle("Blue", 4, 10),
                new Triangle("Green", 3, 4, 5), new Circle("Yellow", 2.5),
                new Rectangle("Pink", 2, 2), new Triangle("Black", 10, 10, 10)
        };

        double total = 0;
        for (Shape x : s) {
            x.displayInfo();
            total += x.getArea();
        }

        Shape big = findLargest(s);
        System.out.println("\nLargest Shape: " + big.getClass().getSimpleName() + " with Area: " + String.format("%.2f", big.getArea()));
        System.out.println("Total Combined Area: " + String.format("%.2f", total));
    }

    static Shape findLargest(Shape[] shapes) {
        Shape max = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > max.getArea()) max = shapes[i];
        }
        return max;
    }
}