import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentFileReader {
    public static void main(String[] args) {
        File file = new File("students.txt");
        int count = 0;

        try (Scanner sc = new Scanner(file)) {
            System.out.printf("%-15s %-5s %-15s%n", "Name", "GPA", "Major");
            System.out.println("---------------------------------------");

            while (sc.hasNext()) {
                String firstName = sc.next();
                String lastName = sc.next();
                double gpa = sc.nextDouble();
                String major = sc.next();

                System.out.printf("%-15s %.2f   %-15s%n", firstName + " " + lastName, gpa, major);
                count++;
            }
            System.out.println("---------------------------------------");
            System.out.println("Total students: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file 'students.txt' was not found. Please run StudentFileWriter first.");
        }
    }
}